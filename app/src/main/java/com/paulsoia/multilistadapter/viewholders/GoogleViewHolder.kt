package com.paulsoia.multilistadapter.viewholders

import android.view.View
import com.paulsoia.multilistadapter.model.ItemGoogle
import kotlinx.android.synthetic.main.list_item_google.view.*

class GoogleViewHolder(view: View) : BaseViewHolder<ItemGoogle>(view) {

    override fun bind(item: ItemGoogle) {
        itemView.tvName.text = item.name
        itemView.tvProduct.text = item.product
        itemView.tvVersion.text = item.version
        if (item.isUse) {
            itemView.tvProduct.visibility = View.GONE
        } else {
            itemView.tvProduct.visibility = View.VISIBLE
        }
    }

}