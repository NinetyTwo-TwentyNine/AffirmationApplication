package com.example.affirmationapplication.data

import com.example.affirmationapplication.adapters.Recycler_Adapter

data class Recycler_ViewModel(val image: Int, val text: String) {
    var function_OnClick: ((Int, Recycler_Adapter.ViewHolder) -> Unit)? = null
}