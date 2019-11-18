package com.filipkowicz.examples.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.filipkowicz.examples.R

class MainViewModel : ViewModel() {

    val items: LiveData<List<ListItem>> = MutableLiveData(
        listOf(
            Data(R.layout.item_layout, "item 1"),
            Data(R.layout.item_layout, "item 2"),
            Data(R.layout.header_layout, "HEADER 1"),
            Data(R.layout.item_layout, "item 3"),
            Data(R.layout.item_layout, "item 4"),
            Data(R.layout.header_layout, "HEADER 2"),
            Data(R.layout.item_layout, "item 5"),
            Data(R.layout.item_layout, "item 6"),
            Data(R.layout.item_layout, "item 7"),
            Data(R.layout.header_layout, "HEADER 3"),
            Data(R.layout.item_layout, "item 8"),
            Data(R.layout.item_layout, "item 9"),
            Data(R.layout.header_layout, "HEADER 4"),
            Data(R.layout.item_layout, "item 10")
        )
    )

    data class Data(
        override val itemType: Int,
        val data: String
    ) : ListItem
}
