package com.paulsoia.multilistadapter.viewholders

import android.view.View
import com.paulsoia.multilistadapter.model.ItemTitle
import kotlinx.android.synthetic.main.list_item_title.view.*

class TitleViewHolder(view: View) : BaseViewHolder<ItemTitle>(view) {

    override fun bind(item: ItemTitle) {
        itemView.tvTitle.text = item.title
        itemView.tvAmount.text = item.amount.toString()
    }

}