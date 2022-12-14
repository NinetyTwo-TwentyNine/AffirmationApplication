package com.example.affirmationapplication

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.affirmationapplication.adapters.Recycler_Adapter
import com.example.affirmationapplication.data.Recycler_ViewModel
import com.example.affirmationapplication.databinding.ActivityMainBinding

class MainActivity: AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        val textData = arrayListOf<String>()
        textData.add("I am strong.")
        textData.add("I believe in myself.")
        textData.add("Each day is a new opportunity to grow and be a better version of myself.")
        textData.add("Every challenge in my life is an opportunity to learn from.")
        textData.add("I have so much to be grateful for.")
        textData.add("Good things are always coming into my life.")
        textData.add("New opportunities await me at every turn.")
        textData.add("I have the courage to follow my heart.")
        textData.add("Things will unfold at precisely the right time.")
        textData.add("I will be present in all the moments that this day brings.")

        val dataList = ArrayList<Recycler_ViewModel>(10)
        for (i in 0 until 10) {
            dataList.add(Recycler_ViewModel(getResources().getIdentifier("image${i+1}", "drawable", getPackageName()), textData[i]))
        }
        dataList[9].function_OnClick = {position, holder->
            holder.textView.setTextColor(holder.textView.currentTextColor + arrayListOf(-100, -50, 50, 100).shuffled().first())
        }

        var dataAdapter = Recycler_Adapter(dataList)

        var recycler_FunctionTemplate: ((Int, Recycler_Adapter.ViewHolder) -> Unit)? = null
        val function_OnClick_RecyclerDefault: ((Int, Recycler_Adapter.ViewHolder) -> Unit) = {position, holder ->
            var viewCopy = dataList[position]
            dataList.removeAt(position)
            dataList.shuffle()
            dataList.add(position, viewCopy)
            dataAdapter = Recycler_Adapter(dataList)
            dataAdapter.function_OnClick = recycler_FunctionTemplate
            binding.recyclerView.adapter = dataAdapter
        }

        recycler_FunctionTemplate = {position, holder ->
            if (dataList[position].function_OnClick != null) {
                dataList[position].function_OnClick!!(position, holder)
            } else {
                function_OnClick_RecyclerDefault(position, holder)
            }
        }

        dataAdapter.function_OnClick = recycler_FunctionTemplate
        binding.recyclerView.adapter = dataAdapter
    }
}