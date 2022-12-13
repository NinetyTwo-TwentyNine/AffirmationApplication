package com.example.affirmationapplication.adapters


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.affirmationapplication.R
import com.example.affirmationapplication.data.Recycler_ViewModel

class Recycler_Adapter(private val dataList: List<Recycler_ViewModel>): RecyclerView.Adapter<Recycler_Adapter.ViewHolder>() {

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView = ItemView.findViewById<ImageView>(R.id.imageView)
        val textView = ItemView.findViewById<TextView>(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_card_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.imageView.setImageResource(dataList[position].image)
        holder.textView.setText(dataList[position].text)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}