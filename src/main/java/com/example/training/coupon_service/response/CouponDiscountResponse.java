package com.example.training.coupon_service.response;

import lombok.Data;

@Data
public class CouponDiscountResponse {
    private String couponCode;
    private double totalPrice;
    private String status;
}
