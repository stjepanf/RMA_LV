package com.example.inspiringperson


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row.view.*

class MyAdapter(private val arrayList: MutableList<InspiringPerson>, val context: Context) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    class ViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems (model: InspiringPerson){
            itemView.Imeprezime.text = model.Imeprezimec
            itemView.opis.text = model.opisc
            itemView.godina.text = model.godinac
            itemView.imageCard.setImageResource(model.imageCardc)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val  v = LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false)
        return  ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return  arrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bindItems(arrayList[position])
    }
}