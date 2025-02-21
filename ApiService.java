package com.payment.phonepe;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("/products")  // The endpoint for fetching products
    Call<List<Product>> getProducts();  // The response is a list of Product objects
}















//package com.payment.phonepe;
//
//import retrofit2.Call;
//import retrofit2.http.GET;
//
//import java.util.List;
//
//public interface ApiService {
//
//    @GET("paymentOptions")  // Sample endpoint
//    Call<List<PaymentOption>> getPaymentOptions();
//}