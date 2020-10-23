package com.paysafe.roiim.repository;

import com.paysafe.roiim.resources.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
    UserEntity findByEmail(String email);
    UserEntity findByMerchantCustomerId(String merchantCustomerId);

}
