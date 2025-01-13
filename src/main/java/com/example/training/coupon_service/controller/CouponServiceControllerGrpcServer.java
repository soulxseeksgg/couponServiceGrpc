package com.example.training.coupon_service.controller;

import com.example.training.coupon_service.business.CouponDiscountBusiness;
import com.example.training.coupon_service.response.CouponDiscountResponse;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.example.GrpcCouponServiceGrpc;
import net.devh.boot.grpc.example.GrpcCouponServiceRequest;
import net.devh.boot.grpc.example.GrpcCouponServiceResponse;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class CouponServiceControllerGrpcServer extends GrpcCouponServiceGrpc.GrpcCouponServiceImplBase{

    private final CouponDiscountBusiness couponDiscountBusiness;

    public CouponServiceControllerGrpcServer(CouponDiscountBusiness couponDiscountBusiness) {
        this.couponDiscountBusiness = couponDiscountBusiness;
    }

    @Override
    public void couponDiscount(GrpcCouponServiceRequest request, StreamObserver<GrpcCouponServiceResponse> responseObserver) {
        CouponDiscountResponse discountResponse= couponDiscountBusiness.validateCouponAndDiscount(request.getCouponCode(),request.getOriginalPrice());

        GrpcCouponServiceResponse response = GrpcCouponServiceResponse.newBuilder()
                .setCouponCode(discountResponse.getCouponCode())
                .setTotalPrice(discountResponse.getTotalPrice())
                .setStatus(discountResponse.getStatus())
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
