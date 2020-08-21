package com.daniellegolinsky.booksapp.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.daniellegolinsky.booksapp.R
import com.daniellegolinsky.booksapp.model.Book

class BooksRecyclerViewAdapter : RecyclerView.Adapter<BooksViewHolder>() {

    private var booksList: List<Book> = listOf()

    fun setList(list: List<Book>) {
        booksList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.book_list_item, parent, false)
        return BooksViewHolder(view)
    }

    override fun getItemCount() = booksList.size

    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {
        holder.bind(booksList[position])
    }
}
