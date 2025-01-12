package com.example.training.coupon_service.mapper;

import com.example.training.coupon_service.entity.CouponEntity;
import com.example.training.coupon_service.response.CouponInfoResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CouponMapper {
    CouponInfoResponse toCouponValidateResponse(CouponEntity coupon);
}
