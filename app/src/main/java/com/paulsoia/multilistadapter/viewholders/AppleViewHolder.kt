package com.paulsoia.multilistadapter.viewholders

import android.view.View
import com.paulsoia.multilistadapter.model.ItemApple
import kotlinx.android.synthetic.main.list_item_apple.view.*

class AppleViewHolder(view: View) : BaseViewHolder<ItemApple>(view) {

    override fun bind(item: ItemApple) {
        //можем делать так
        itemView.tvName.text = item.name
        itemView.tvCountry.text = item.country
        itemView.tvYear.text = item.year.toString()

        /*----сверху и снизу два идентичных блока----*/

        //а можем сделать такой блок и не использовать в каждой строке itemView
        with(itemView) {
            tvName.text = item.name
            tvCountry.text = item.country
            tvYear.text = item.year.toString()
        }
    }

}