package com.example.training.coupon_service.repository;

import com.example.training.coupon_service.entity.CouponEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;


public interface CouponRepositoty extends MongoRepository<CouponEntity,String> {
    Optional<CouponEntity> findByCouponCode(String couponCode);
}
