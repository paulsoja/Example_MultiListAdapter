package com.paulsoia.multilistadapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.paulsoia.multilistadapter.model.ItemApple
import com.paulsoia.multilistadapter.model.ItemGoogle
import com.paulsoia.multilistadapter.model.ItemTitle
import com.paulsoia.multilistadapter.model.ListMarker
import com.paulsoia.multilistadapter.viewholders.AppleViewHolder
import com.paulsoia.multilistadapter.viewholders.BaseViewHolder
import com.paulsoia.multilistadapter.viewholders.GoogleViewHolder
import com.paulsoia.multilistadapter.viewholders.TitleViewHolder

class ListAdapter : RecyclerView.Adapter<BaseViewHolder<*>>() {

    companion object {
        //задаем константы для каждого типа айтема
        private const val TYPE_TITLE = 0
        private const val TYPE_GOOGLE = 1
        private const val TYPE_APPLE = 2
    }

    //здесь можно использовать обычный ArrayList
    //сюда добавляются все айтемы, которые реализовали интерфейс ListMarker
    //как вариант можно было сделать mutableListOf<Any>() и обойтись без интерфейса
    private val items = mutableListOf<ListMarker>()

    internal fun swapData(list: List<ListMarker>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return when(viewType) {
            //задаем разметку для каждого типа айтема
            TYPE_TITLE -> TitleViewHolder(parent.inflate(R.layout.list_item_title))
            TYPE_GOOGLE -> GoogleViewHolder(parent.inflate(R.layout.list_item_google))
            TYPE_APPLE -> AppleViewHolder(parent.inflate(R.layout.list_item_apple))
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is ItemTitle -> TYPE_TITLE
            is ItemGoogle -> TYPE_GOOGLE
            is ItemApple -> TYPE_APPLE
            else -> throw IllegalArgumentException("Invalid type of item $position")
        }
    }

    override fun getItemCount(): Int {
        //этот метод определяет размер списка
        return items.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        val element = items[position]
        when (holder) {
            //отправляем каждый айтем к своему ViewHolder
            is TitleViewHolder -> holder.bind(element as ItemTitle)
            is GoogleViewHolder -> holder.bind(element as ItemGoogle)
            is AppleViewHolder -> holder.bind(element as ItemApple)
            else -> throw IllegalArgumentException()
        }
    }

}