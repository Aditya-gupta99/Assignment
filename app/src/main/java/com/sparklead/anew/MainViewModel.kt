package com.sparklead.anew

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel(private val productRepository: ProductRepository = ProductRepository()): ViewModel(){

    var productDetails : MutableLiveData<Product> = MutableLiveData()


    fun getProductList() {
        viewModelScope.launch {
            val result =productRepository.getProduct()
            if(result.body() != null)
            {
                productDetails.postValue(result.body())
            }
        }
    }
}