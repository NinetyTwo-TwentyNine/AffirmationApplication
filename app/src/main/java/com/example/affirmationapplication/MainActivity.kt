package com.example.affirmationapplication

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
        for (i in 1..10) {
            dataList.add(Recycler_ViewModel(getResources().getIdentifier("image$i", "drawable", getPackageName()), textData[i-1]))
        }
        binding.recyclerView.adapter = Recycler_Adapter(dataList)
    }
}