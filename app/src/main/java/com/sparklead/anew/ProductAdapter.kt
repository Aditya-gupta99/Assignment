package com.sparklead.anew

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ProductAdapter(
    private val context: Context,
    private val itemList: List<ProductX>
) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.product_item_list, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val model = itemList[position]
        holder.itemView.findViewById<TextView>(R.id.tvTitle).text =  model.title
        holder.itemView.findViewById<TextView>(R.id.tvDescription).text =  model.description
        Glide.with(context).load(model.images).placeholder(R.drawable.ic_launcher_background).into(holder.itemView.findViewById(R.id.ivArticleImage))

    }
}