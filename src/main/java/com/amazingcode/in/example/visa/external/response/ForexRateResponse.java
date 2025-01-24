package com.amazingcode.in.example.visa.external.response;

public class ForexRateResponse {

    private String conversionRate;
    private String destinationAmount;
    private String rateProductCode;
    private String markupRateApplied;
    private String sourceAmountWithoutMarkup;
    private AcquirerDetails acquirerDetails;

    public String getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(String conversionRate) {
        this.conversionRate = conversionRate;
    }

    public String getDestinationAmount() {
        return destinationAmount;
    }

    public void setDestinationAmount(String destinationAmount) {
        this.destinationAmount = destinationAmount;
    }

    public String getRateProductCode() {
        return rateProductCode;
    }

    public void setRateProductCode(String rateProductCode) {
        this.rateProductCode = rateProductCode;
    }

    public String getMarkupRateApplied() {
        return markupRateApplied;
    }

    public void setMarkupRateApplied(String markupRateApplied) {
        this.markupRateApplied = markupRateApplied;
    }

    public String getSourceAmountWithoutMarkup() {
        return sourceAmountWithoutMarkup;
    }

    public void setSourceAmountWithoutMarkup(String sourceAmountWithoutMarkup) {
        this.sourceAmountWithoutMarkup = sourceAmountWithoutMarkup;
    }

    public AcquirerDetails getAcquirerDetails() {
        return acquirerDetails;
    }

    public void setAcquirerDetails(AcquirerDetails acquirerDetails) {
        this.acquirerDetails = acquirerDetails;
    }

    public static class AcquirerDetails {

        private Settlement settlement;

        public Settlement getSettlement() {
            return settlement;
        }

        public void setSettlement(Settlement settlement) {
            this.settlement = settlement;
        }

        public static class Settlement {
            private String currencyCode;
            private String amount;
            private String conversionRate;

            public String getCurrencyCode() {
                return currencyCode;
            }

            public void setCurrencyCode(String currencyCode) {
                this.currencyCode = currencyCode;
            }

            public String getAmount() {
                return amount;
            }

            public void setAmount(String amount) {
                this.amount = amount;
            }

            public String getConversionRate() {
                return conversionRate;
            }

            public void setConversionRate(String conversionRate) {
                this.conversionRate = conversionRate;
            }
        }
    }
}
