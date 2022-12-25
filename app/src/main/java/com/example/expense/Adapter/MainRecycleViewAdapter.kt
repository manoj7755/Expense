package com.example.expense.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.expense.ModelClass.ModelOfItemRow
import com.example.expense.R
import kotlinx.android.synthetic.main.item_row.view.*

class MainRecycleViewAdapter(val context: Context, val arrayData:ArrayList<ModelOfItemRow>) : RecyclerView.Adapter<MainRecycleViewAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productImg = itemView.img
        val productName = itemView.productName
        val proudctBrand = itemView.brandName
        val productPrice1 = itemView.price1
        val productPrice2 = itemView.price2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
     holder.productImg.setImageResource(arrayData[position].img)
        holder.productName.text = arrayData[position].Product_Name
        holder.proudctBrand.text = arrayData[position].Brand
        holder.productPrice1.text = arrayData[position].Price1
        holder.productPrice2.text = arrayData[position].Price2
    }

    override fun getItemCount(): Int {
return arrayData.size
    }
}