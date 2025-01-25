# crud-with-quarkus
# payment-exchange

This project implements a **Currency Conversion Service** using the Quarkus framework. The service interacts with Visa APIs to perform currency conversion operations. The project follows a **Hexagonal Architecture**, ensuring modularity and separation of concerns.

The Payment Exchange Service provides an API endpoint to convert currency amounts using Visa's Foreign Exchange Rates API. The service ensures secure communication with Visa APIs using SSL.

## Features

- **Currency Conversion:** Convert amounts between different currencies using Visa's Forex API.
- **Secure Communication:** Utilizes SSL for secure interactions with Visa APIs.
- **Hexagonal Architecture:** Promotes maintainability and testability.
- **REST API:** Exposes endpoints for client interaction.
- **Configuration Management:** Supports externalized configuration through `application.properties`.

## Prerequisites

Before you begin, ensure you have the following tools and credentials:

- Java 21 or higher
- Gradle
- Visa API credentials (see below for details on how to obtain them)
- A valid keystore for SSL communication with Visa API (see instructions below)
- Quarkus CLI (optional for development)

---

### Getting Visa API Credentials (PEM Key/Certificate)

This guide explains how to create a project on the VISA Developer platform and retrieve the required `.pem` certificate and key.

#### Prerequisites for Visa API Credentials

Before you begin, ensure you have the following:

1. **VISA Developer Account:** Register at [VISA Developer Portal](https://developer.visa.com/) if you don't already have an account.
2. **Basic Knowledge of VISA APIs:** Familiarize yourself with the APIs available on the portal.
3. **SSL Certificate Tools:** Tools like OpenSSL for managing `.pem` files.

#### Steps to Create a VISA Developer Project

1. **Log In to VISA Developer Portal**
   - Go to [VISA Developer Portal](https://developer.visa.com/) and log in using your credentials.

2. **Create a New Project**
   - Click on `My Projects` in the top menu.
   - Click `Create a New Project`.
   - Fill out the project details:
     - **Project Name:** Enter a meaningful name.
     - **Description:** Provide a brief description of your project.
     - **APIs:** Select the APIs required for your project.

3. **Specify Use Case and Regional Preferences**
   - Select your use case and specify your region to tailor the project to your needs.

4. **Enable Mutual Authentication**
   - Choose the authentication method as `Mutual Authentication (Two-Way SSL)`.

5. **Generate Credentials**
   - Once the project is created, navigate to the `Credentials` section of your project.
   - Click `Generate Certificate`. You will see the key and certificate. Download them and store them securely on your system.

---

### Steps to Generate SSL KeyStore

This guide provides the necessary steps to convert PEM files into a PKCS12 bundle and then into a JKS (Java KeyStore) file. Follow these steps carefully.

#### Prerequisites

Before you begin, ensure you have the following:

- OpenSSL installed on your system.
- Java Keytool available (usually comes with JDK installations).
- PEM files:
  - `project_cert.pem`: The certificate file.
  - `project_key.pem`: The private key file.
- Destination paths for generated files.

#### Steps

**1. Convert PEM Files to PKCS12 Format**

Use the following command to combine the certificate and private key into a PKCS12 bundle:

```bash
openssl pkcs12 -export -in D:\path\to\project_cert.pem -inkey "D:\path\to\project_key.pem" -certfile D:\path\to\project_cert.pem -out D:\path\to\generate\myProject_keyAndCertBundle.p12
```

**Parameters:**

- `-in`: Path to the certificate file.
- `-inkey`: Path to the private key file.
- `-certfile`: Additional certificates to include (in this case, the same certificate file).
- `-out`: Path to save the PKCS12 bundle.

You will be prompted to set an export password for the PKCS12 file. Remember this password for the next step.

**2. Convert PKCS12 to JKS Format**

Use the `keytool` command to convert the PKCS12 bundle into a Java KeyStore (JKS):

```bash
keytool -importkeystore -srckeystore D:\path\to\myProject_keyAndCertBundle.p12 -srcstoretype PKCS12 -destkeystore D:\path\to\generate\myProject_keyAndCertBundle.jks
```

**Parameters:**

- `-srckeystore`: Path to the PKCS12 file.
- `-srcstoretype`: Source keystore type (PKCS12).
- `-destkeystore`: Path to save the Java KeyStore file.

You will be prompted for the following passwords:

1. The export password for the PKCS12 file (set in Step 1).
2. A strong password for the destination JKS file.

---

## Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/nimbuspay/payment-exchange.git
cd payment-exchange
```

### 2. Import the Project

Use your favorite IDE (e.g., IntelliJ IDEA, VS Code) to import the project as a Gradle or Quarkus project.

---

## Configuration

Update the `application.properties` file located in `src/main/resources` with your Visa API credentials and SSL keystore information:

```properties
visa.base.url=https://sandbox.api.visa.com
visa.api.url=https://sandbox.api.visa.com/forexrates/v2/foreignexchangerates
visa.api.username=<your-username>
visa.api.password=<your-password>
ssl.keystore.path=<path-to-your-keystore>
ssl.keystore.password=<your-keystore-password>
```

---

## Running the Application

### 1. Start the Application

Run the following command to start the Quarkus application:

```bash
./gradlew quarkusDev
```

The application will be available at `http://localhost:8080`.

### 2. Test the API

Use a tool like **Postman**. For example:

#### Request

Send a `POST` request to `/currency-conversion/fxRate` with the following payload:

```json
{
  "destinationCurrencyCode": "826",
  "rateProductCode": "B",
  "sourceAmount": "100.00",
  "sourceCurrencyCode": "840",
  "markupRate": "65",
  "acquirerDetails": {
    "bin": "408999",
    "settlement": {
      "currencyCode": "840"
    }
  }
}
```

#### Response

```json
{
    "conversionRate": "0.7780290",
    "destinationAmount": "47.16",
    "rateProductCode": "B",
    "markupRateApplied": "65",
    "sourceAmountWithoutMarkup": "60.61",
    "acquirerDetails": {
        "settlement": {
            "currencyCode": "840",
            "amount": "60.61",
            "conversionRate": "1.000000"
        }
    }
}
```

