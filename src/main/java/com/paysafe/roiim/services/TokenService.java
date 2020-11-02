package com.paysafe.roiim.services;

import com.paysafe.roiim.model.RequestDetails;
import com.paysafe.roiim.model.SingleUseCustomerToken;
import com.paysafe.roiim.model.SingleUseRequestBody;
import com.paysafe.roiim.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static com.paysafe.roiim.utils.Constants.API_KEY;

@Service
public class TokenService {

    private UserRepository userRepository;

    @Autowired
    TokenService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public SingleUseCustomerToken customerToken(RequestDetails requestDetails) {

        String email = requestDetails.getEmail();
        SingleUseRequestBody singleUseRequestBody = new SingleUseRequestBody(requestDetails.getMerchantRefNum());
        singleUseRequestBody.addPayment("CARD");
        if (userRepository.findByEmail(email) == null)
            return null;
            //else block will fetch singleUseCustomerToken from paysafe server
        else {
            String id = userRepository.findByEmail(email).getCustomerId();
            String url = "https://api.test.paysafe.com/paymenthub/v1/customers/" + id + "/singleusecustomertokens";
            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", API_KEY);
            headers.add("Content-Type", "application/json");
            HttpEntity<SingleUseRequestBody> request = new HttpEntity<SingleUseRequestBody>(singleUseRequestBody, headers);
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<SingleUseCustomerToken> result = restTemplate.postForEntity(url, request, SingleUseCustomerToken.class);
            //System.out.println(singleUseReqBody.getMerchantRefNumber());
            return (result.getBody() != null) ? result.getBody() : null;
        }
    }

}
