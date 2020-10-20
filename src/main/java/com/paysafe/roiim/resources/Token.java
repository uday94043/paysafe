package com.paysafe.roiim.resources;

//this class holds attribute that we will send to paysafe server for processing request
public class Token {
    private String paymentHandleToken;
    private String merchantRefNum;
    private Integer amount;
    private String currencyCode;
    private String merchantCustomerId;
    private String customerId;

    public Token(String paymentHandleToken, String merchantRefNum, Integer amount, String currencyCode) {
        this.paymentHandleToken = paymentHandleToken;
        this.merchantRefNum = merchantRefNum;
        this.amount = amount;
        this.currencyCode = currencyCode;
    }


    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getMerchantCustomerId() {
        return merchantCustomerId;
    }

    public void setMerchantCustomerId(String merchantCustomerId) {
        this.merchantCustomerId = merchantCustomerId;
    }

    public String getPaymentHandleToken() {
        return paymentHandleToken;
    }

    public void setPaymentHandleToken(String paymentHandleToken) {
        this.paymentHandleToken = paymentHandleToken;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getMerchantRefNum() {
        return merchantRefNum;
    }

    public void setMerchantRefNum(String merchantRefNum) {
        this.merchantRefNum = merchantRefNum;
    }
}
