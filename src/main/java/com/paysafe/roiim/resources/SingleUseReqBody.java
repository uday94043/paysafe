package com.paysafe.roiim.resources;

public class SingleUseReqBody {

    String merchantRefNumber;
    String[] paymentTypes;

    public SingleUseReqBody(String merchantRefNumber) {
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
