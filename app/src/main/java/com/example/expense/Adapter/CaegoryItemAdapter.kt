package com.example.expense.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.expense.ModelClass.CategoryModel
import com.example.expense.R
import kotlinx.android.synthetic.main.category_item.view.*

class CaegoryItemAdapter(val context: Context,val arrayData:ArrayList<CategoryModel>):RecyclerView.Adapter<CaegoryItemAdapter.ViewHodel>() {
    class ViewHodel(val ItemView: View):RecyclerView.ViewHolder(ItemView) {
       val profileImg = ItemView.profile_image
        val ProfileName = ItemView.profile_name

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHodel {
        return ViewHodel(LayoutInflater.from(parent.context).inflate(R.layout.category_item,parent,false))

    }

    override fun onBindViewHolder(holder: ViewHodel, position: Int) {
        holder.profileImg.setImageResource(arrayData[position].profileImg)
        holder.ProfileName.text = arrayData[position].profileName
    }

    override fun getItemCount(): Int {
       return arrayData.size
    }
}