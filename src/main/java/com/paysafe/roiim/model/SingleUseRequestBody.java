package com.paysafe.roiim.model;

public class SingleUseRequestBody {

    String merchantRefNumber;
    String[] paymentTypes;

    public SingleUseRequestBody(String merchantRefNumber) {
        this.merchantRefNumber = merchantRefNumber;
        this.paymentTypes = new String[1];
    }

    public String getMerchantRefNumber() {
        return merchantRefNumber;
    }

    public String[] getPaymentTypes() {
        return paymentTypes;
    }

    public void addPayment(String paymentMethod){
        paymentTypes[0] = paymentMethod;
    }
}
