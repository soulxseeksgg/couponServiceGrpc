package com.example.training.coupon_service.business;

import com.example.training.coupon_service.response.CouponDiscountResponse;
import com.example.training.coupon_service.response.CouponInfoResponse;
import com.example.training.coupon_service.service.CouponService;
import org.springframework.stereotype.Service;

@Service
public class CouponDiscountBusiness {

    private final CouponService couponService;

    public CouponDiscountBusiness(CouponService couponService) {
        this.couponService = couponService;
    }

    public CouponDiscountResponse validateCouponAndDiscount(String couponCode, double originalPrice){
        CouponInfoResponse couponData = couponService.validateCoupon(couponCode);
        double totalPrice = couponService.calculateDiscount(originalPrice, couponData.getDiscountPrice());

        CouponDiscountResponse response = new CouponDiscountResponse();
        response.setCouponCode(couponData.getCouponCode());
        response.setTotalPrice(totalPrice);
        response.setStatus(couponData.getStatus());
        return  response;
    }
}
