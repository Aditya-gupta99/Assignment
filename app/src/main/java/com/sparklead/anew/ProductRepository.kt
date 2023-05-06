package com.sparklead.anew

class ProductRepository() {
    suspend fun getProduct() = RetrofitInstance.product.getProduct()
}