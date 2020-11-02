package com.paysafe.roiim.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TokenDetails {
    private String paymentHandleToken;
    private String merchantRefNum;
    private Integer amount;
    private String currencyCode;
    private String merchantCustomerId;
    private String customerId;

    public TokenDetails(String paymentHandleToken, String merchantRefNum, Integer amount, String currencyCode) {
        this.paymentHandleToken = paymentHandleToken;
        this.merchantRefNum = merchantRefNum;
        this.amount = amount;
        this.currencyCode = currencyCode;
    }

}
