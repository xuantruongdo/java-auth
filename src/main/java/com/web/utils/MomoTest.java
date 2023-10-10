//package com.web.utils;
//
//import com.mservice.config.Environment;
//import com.mservice.enums.RequestType;
//import com.mservice.models.PaymentResponse;
//import com.mservice.processor.CreateOrderMoMo;
//
//public class MomoTest {
//
//    public static void main(String... args) throws Exception {
//        String requestId = String.valueOf(System.currentTimeMillis());
//        String orderId = String.valueOf(System.currentTimeMillis());
//        Long transId = 2L;
//        long amount = 50000;
//
//        String partnerClientId = "partnerClientId";
//        String orderInfo = "Pay With MoMo";
//        String returnURL = "https://google.com.vn";
//        String notifyURL = "https://google.com.vn";
//        String callbackToken = "callbackToken";
//        String token = "";
//
//        Environment environment = Environment.selectEnv("dev");
//        PaymentResponse captureWalletMoMoResponse = CreateOrderMoMo.process(environment, orderId, requestId, Long.toString(amount), orderInfo, returnURL, notifyURL, "", RequestType.CAPTURE_WALLET, Boolean.TRUE);
//
//        /***
//         * create payment with Momo's ATM type
//         */
//
//        orderId = String.valueOf(System.currentTimeMillis());
//        requestId = String.valueOf(System.currentTimeMillis());
//        PaymentResponse captureATMMoMoResponse = CreateOrderMoMo.process(environment, orderId, requestId, Long.toString(amount), orderInfo, returnURL, notifyURL, "", RequestType.PAY_WITH_ATM, null);
//
//        System.out.println(captureATMMoMoResponse.getQrCodeUrl());
//
//
//    }
//
//}
