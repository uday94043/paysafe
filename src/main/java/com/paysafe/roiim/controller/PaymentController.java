package com.paysafe.roiim.controller;

import com.paysafe.roiim.model.RequestDetails;
import com.paysafe.roiim.model.SingleUseCustomerToken;
import com.paysafe.roiim.services.PaymentService;
import com.paysafe.roiim.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static com.paysafe.roiim.utils.Constants.PAYMENT_END_POINT;
import static com.paysafe.roiim.utils.Constants.SINGLE_USER_CUSTOMER_TOKEN_ENDPOINT;


@CrossOrigin
@RestController
public class PaymentController {

    private TokenService tokenService;
    private PaymentService paymentService;

    @Autowired
    PaymentController(TokenService tokenService, PaymentService paymentService) {
        this.tokenService = tokenService;
        this.paymentService = paymentService;
    }

    @PostMapping(SINGLE_USER_CUSTOMER_TOKEN_ENDPOINT)
    @ResponseBody
    public SingleUseCustomerToken customerToken(@RequestBody RequestDetails requestDetails) {

        return tokenService.customerToken(requestDetails);

    }

    //processing payment and save card
    @PostMapping(PAYMENT_END_POINT)
    public HttpStatus payment(@RequestBody RequestDetails requestDetails) {

        return paymentService.payment(requestDetails);

    }
}
