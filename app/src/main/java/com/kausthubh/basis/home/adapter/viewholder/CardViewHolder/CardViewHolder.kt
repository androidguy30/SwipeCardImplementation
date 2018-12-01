package com.kausthubh.basis.home.adapter.viewholder.CardViewHolder

import android.support.v7.widget.AppCompatTextView
import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.card_item_layout.view.*


class CardViewHolder(var view: View) : RecyclerView.ViewHolder(view) {

    var author: AppCompatTextView = view.author
    var quote: AppCompatTextView = view.quotes
}