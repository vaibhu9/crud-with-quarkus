package com.amazingcode.in.example.visa.external.ssl;

import jakarta.ws.rs.Produces;
import javax.net.ssl.SSLContext;

import com.amazingcode.in.example.visa.external.exception.SSLContextFailedException;

import java.io.FileInputStream;
import java.security.KeyStore;
import javax.net.ssl.KeyManagerFactory;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SSLContextProducer {

    private static final String KEYSTORE_PATH = "D:\\VAIBHAV SHEJOL\\Git Hub Repo\\amazingcode-in\\crud-with-quarkus\\src\\main\\resources\\myProject_keyAndCertBundle.jks";
    private static final String KEYSTORE_PASSWORD = "root1234";

    @Produces
    public SSLContext produceSSLContext() {
        try {
            // Load the keystore
            KeyStore keyStore = KeyStore.getInstance("JKS");
            try (FileInputStream keyStoreStream = new FileInputStream(KEYSTORE_PATH)) {
                keyStore.load(keyStoreStream, KEYSTORE_PASSWORD.toCharArray());
            }

            // Create key and trust managers
            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunX509");
            keyManagerFactory.init(keyStore, KEYSTORE_PASSWORD.toCharArray());

            // Initialize SSL context
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(keyManagerFactory.getKeyManagers(), null, null);

            return sslContext;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SSLContextFailedException("Failed to create SSLContext"+e.getMessage());
        }
    }
}
