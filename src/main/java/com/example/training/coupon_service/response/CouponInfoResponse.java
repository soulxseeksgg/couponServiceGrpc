package com.example.training.coupon_service.response;

import lombok.Data;

@Data
public class CouponInfoResponse {
    private String couponCode;
    private double discountPrice;
    private String status;
}