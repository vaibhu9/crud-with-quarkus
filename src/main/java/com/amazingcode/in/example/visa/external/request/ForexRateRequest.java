package com.amazingcode.in.example.visa.external.request;

public class ForexRateRequest {

    private String destinationCurrencyCode;
    private String rateProductCode;
    private String sourceAmount;
    private String sourceCurrencyCode;
    private String markupRate;
    private AcquirerDetails acquirerDetails;

    public String getDestinationCurrencyCode() {
        return destinationCurrencyCode;
    }

    public void setDestinationCurrencyCode(String destinationCurrencyCode) {
        this.destinationCurrencyCode = destinationCurrencyCode;
    }

    public String getRateProductCode() {
        return rateProductCode;
    }

    public void setRateProductCode(String rateProductCode) {
        this.rateProductCode = rateProductCode;
    }

    public String getSourceAmount() {
        return sourceAmount;
    }

    public void setSourceAmount(String sourceAmount) {
        this.sourceAmount = sourceAmount;
    }

    public String getSourceCurrencyCode() {
        return sourceCurrencyCode;
    }

    public void setSourceCurrencyCode(String sourceCurrencyCode) {
        this.sourceCurrencyCode = sourceCurrencyCode;
    }

    public String getMarkupRate() {
        return markupRate;
    }

    public void setMarkupRate(String markupRate) {
        this.markupRate = markupRate;
    }

    public AcquirerDetails getAcquirerDetails() {
        return acquirerDetails;
    }

    public void setAcquirerDetails(AcquirerDetails acquirerDetails) {
        this.acquirerDetails = acquirerDetails;
    }

    public static class AcquirerDetails {

        private String bin;
        private Settlement settlement;

        public String getBin() {
            return bin;
        }

        public void setBin(String bin) {
            this.bin = bin;
        }

        public Settlement getSettlement() {
            return settlement;
        }

        public void setSettlement(Settlement settlement) {
            this.settlement = settlement;
        }

        public static class Settlement {
            private String currencyCode;

            public String getCurrencyCode() {
                return currencyCode;
            }

            public void setCurrencyCode(String currencyCode) {
                this.currencyCode = currencyCode;
            }
        }
    }
}
