package com.kausthubh.basis.home.adapter.viewholder

import android.os.Build
import android.support.v7.widget.RecyclerView
import android.text.Html
import android.view.LayoutInflater
import android.view.ViewGroup
import com.kausthubh.basis.R
import com.kausthubh.basis.home.adapter.viewholder.CardViewHolder.CardViewHolder

class CardAdapter : RecyclerView.Adapter<CardViewHolder>() {
    var quotes = arrayOf(
        "Be yourself; everyone else is already taken",
        "Be the change that you wish to see in the world.",
        "No one can make you feel inferior without your consent.",
        "Without music, life would be a mistake.",
        "We accept the love we think we deserve."
    )
    var author = arrayOf("Oscar Wilde", "Mahatma Gandhi", "Eleanor Roosevelt", "Friedrich Nietzsche", "Stephen Chbosky")

    override fun onCreateViewHolder(viewGroup: ViewGroup, itemType: Int): CardViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_item_layout, viewGroup, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: CardViewHolder, position: Int) {
        viewHolder.author.text = author[position]
        val tempText = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Html.fromHtml("&quot;" + quotes[position] + "&quot;", Html.FROM_HTML_MODE_LEGACY).toString()
        } else {
            Html.fromHtml("&quot;" + quotes[position] + "&quot;").toString()
        }

        viewHolder.quote.text = tempText
    }

    override fun getItemCount(): Int {
        return quotes.size
    }


}