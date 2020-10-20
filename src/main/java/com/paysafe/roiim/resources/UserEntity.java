package com.paysafe.roiim.resources;
import javax.persistence.*;

@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String customerId;
    private String merchantCustomerId;

    public UserEntity(String email, String customerId, String merchantCustomerId) {
        this.email = email;
        this.customerId = customerId;
        this.merchantCustomerId = merchantCustomerId;
    }

    public String getMerchantCustomerId() {
        return merchantCustomerId;
    }

    public void setMerchantCustomerId(String merchantCustomerId) {
        this.merchantCustomerId = merchantCustomerId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
