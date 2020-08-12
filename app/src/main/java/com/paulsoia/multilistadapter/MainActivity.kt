package com.paulsoia.multilistadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.paulsoia.multilistadapter.model.ItemApple
import com.paulsoia.multilistadapter.model.ItemGoogle
import com.paulsoia.multilistadapter.model.ItemTitle
import com.paulsoia.multilistadapter.model.ListMarker
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val adapter = ListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        rvList.layoutManager = LinearLayoutManager(this)

        //здесь мы задаем разделитель между айтемами, чтоб они не сливались друг с другом
        val divider = DividerItemDecoration(this, LinearLayoutManager.VERTICAL)
        rvList.addItemDecoration(divider)

        rvList.adapter = adapter
        stubData()
    }

    private fun stubData() {
        val list = mutableListOf<ListMarker>()
        list.add(ItemTitle("title1", 4))
        list.add(ItemGoogle("android", "product1", "17.0v", true))
        list.add(ItemGoogle("no name", "product2", "3.1v", false))
        list.add(ItemApple("macOs", "USA", 2005))
        list.add(ItemApple("iOs", "China", 2007))
        list.add(ItemTitle("title2", 2))
        list.add(ItemGoogle("map", "product3", "23.0v", true))
        list.add(ItemApple("car", "England", 2018))
        list.add(ItemTitle("title3", 0))
        //отправляем все данные в адаптер
        adapter.swapData(list)
    }
}