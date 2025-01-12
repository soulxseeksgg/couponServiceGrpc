package com.example.training.coupon_service.service;

import com.example.training.coupon_service.entity.CouponEntity;
import com.example.training.coupon_service.mapper.CouponMapper;
import com.example.training.coupon_service.repository.CouponRepositoty;
import com.example.training.coupon_service.response.CouponInfoResponse;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CouponService {

    private final CouponRepositoty couponRepositoty;
    private final CouponMapper couponMapper;

    public CouponService(CouponRepositoty couponRepositoty, CouponMapper couponMapper) {
        this.couponRepositoty = couponRepositoty;
        this.couponMapper = couponMapper;
    }

    public CouponInfoResponse validateCoupon(String couponCode){
        Optional<CouponEntity> byCouponCode = couponRepositoty.findByCouponCode(couponCode);

        if(byCouponCode.isEmpty()){
            //throw Exception
        }

        CouponEntity coupon = byCouponCode.get();
        if(coupon.getCouponCode().isEmpty()){
            //throw Exception
        }

        return couponMapper.toCouponValidateResponse(coupon);
    }

    public double calculateDiscount(double originalPirce, double discountPrice){
        double totalPrice = originalPirce-discountPrice;
        return totalPrice;
    }
}
