package com.paysafe.roiim.services;

import com.paysafe.roiim.model.RequestDetails;
import com.paysafe.roiim.model.TokenDetails;
import com.paysafe.roiim.model.UserEntity;
import com.paysafe.roiim.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ThreadLocalRandom;

import static com.paysafe.roiim.utils.Constants.API_KEY;

@Service
public class PaymentService {
    private UserRepository userRepository;

    @Autowired
    PaymentService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public HttpStatus payment(RequestDetails requestDetails) {

        TokenDetails tokenDetails = new TokenDetails(requestDetails.getPaymentHandleToken(), requestDetails.getMerchantRefNum(), requestDetails.getAmount(), requestDetails.getCurrencyCode());

        //save card flow
        if (requestDetails.getCustomerOperation() != null && requestDetails.getCustomerOperation().equals("ADD")) {
            String merchantCustomerId;
            //this block will generate merchantCustomerId
            if (userRepository.findByEmail(requestDetails.getEmail()) == null) {
                //System.out.println("cid is "+ tokenDetails.getCustomerId());
                do {
                    long number = ThreadLocalRandom.current().nextLong(1000000);
                    merchantCustomerId = "sno" + number;
                } while (userRepository.findByMerchantCustomerId(merchantCustomerId) != null);

                tokenDetails.setMerchantCustomerId(merchantCustomerId);
            } else {
                tokenDetails.setCustomerId(userRepository.findByEmail(requestDetails.getEmail()).getCustomerId());
            }
        }
        final String url = "https://api.test.paysafe.com/paymenthub/v1/payments";
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", API_KEY);
        headers.add("Content-Type", "application/json");
        HttpEntity<TokenDetails> request = new HttpEntity<TokenDetails>(tokenDetails, headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserEntity> result = restTemplate.postForEntity(url, request, UserEntity.class);

        //if user is registering for first time, this block will save their customer ID in db
        if (result.getBody() != null && requestDetails.getCustomerOperation() != null && requestDetails.getCustomerOperation().equals("ADD")
                && tokenDetails.getMerchantCustomerId() != null) {
            UserEntity userEntity = new UserEntity(requestDetails.getEmail(), result.getBody().getCustomerId(), tokenDetails.getMerchantCustomerId());
            userRepository.save(userEntity);
        }
        return result.getStatusCode();
    }
}
