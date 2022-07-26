package com.example.crudkotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.crudkotlin.R
import com.example.crudkotlin.model.DataItem
import kotlinx.android.synthetic.main.item_data.view.*
import org.jetbrains.anko.sdk27.coroutines.onClick


class DataAdapter(val data: List<DataItem>? , private val click: onClickItem) : RecyclerView.Adapter<DataAdapter.MyHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_data, parent, false)
        return MyHolder(view)
    }

    override fun getItemCount() = data?.size ?: 0

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.onbind(data?.get(position))
        holder.itemView.onClick {
            click.clicked(data?.get(position))
        }
        holder.itemView.btnHapus.setOnClickListener {
            click.delete(data?.get(position))
        }
    }

    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onbind(get: DataItem?) {
            itemView.tvName.text = get?.staffName
            itemView.tvPhone.text = get?.staffHP
            itemView.tvAddress.text = get?.staffAlamat
        }

    }

    interface onClickItem {
        fun clicked(item: DataItem?)
        fun delete(item: DataItem?)
    }
}