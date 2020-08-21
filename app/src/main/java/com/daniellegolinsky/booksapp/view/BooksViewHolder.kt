package com.daniellegolinsky.booksapp.view

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.daniellegolinsky.booksapp.R
import com.daniellegolinsky.booksapp.model.Book

class BooksViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private var title: TextView = itemView.findViewById(R.id.list_item_book_title)
    private var author: TextView = itemView.findViewById(R.id.list_item_book_author)

    fun bind(book: Book) {
        title.text = book.title
        author.text = book.author
    }
}