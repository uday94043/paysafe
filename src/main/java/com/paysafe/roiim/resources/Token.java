package com.paysafe.roiim.resources;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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

}
