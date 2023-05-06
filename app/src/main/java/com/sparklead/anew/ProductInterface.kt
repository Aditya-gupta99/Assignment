package com.sparklead.anew

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface ProductInterface {

    @Headers("Content-Type: application/json")
    @GET("products/")
    suspend fun getProduct() : Response<Product>
}