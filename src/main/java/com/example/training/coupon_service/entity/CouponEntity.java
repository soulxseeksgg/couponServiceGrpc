package com.example.training.coupon_service.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "couponData")
public class CouponEntity {

    @Id
    private String id;

    private String couponCode;
    private double discountPrice;
    private String status;
}
