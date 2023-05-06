package com.sparklead.anew

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class MainActivity : AppCompatActivity() {

    private val viewModel : MainViewModel by lazy { ViewModelProvider(this)[MainViewModel::class.java]}
    private lateinit var list : List<ProductX>
    private lateinit var productAdapter :ProductAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        viewModel.getProductList()
        viewModel.productDetails.observe(this){
            list =it.products
            setRecycleView()
        }
    }

    private fun setRecycleView() {
        productAdapter = ProductAdapter(this,list)
        val staggeredGridLayoutManager = StaggeredGridLayoutManager( 1, LinearLayoutManager.VERTICAL)
        val recycle = findViewById<RecyclerView>(R.id.rv_product)
        recycle.apply {
            layoutManager = staggeredGridLayoutManager
            adapter = productAdapter
        }
    }
}