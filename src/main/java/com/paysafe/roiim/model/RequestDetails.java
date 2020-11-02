package com.paysafe.roiim.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestDetails {
    private String paymentHandleToken;
    private String merchantRefNum;
    private String customerOperation;
    private Integer amount;
    private String currencyCode;
    private String email;
    private String merchantCustomerId;
    private String customerId;
}
