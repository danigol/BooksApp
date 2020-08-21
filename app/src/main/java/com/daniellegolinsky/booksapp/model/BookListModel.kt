package com.daniellegolinsky.booksapp.model

import android.util.Log
import io.reactivex.Observable
import javax.inject.Inject

class BookListModel @Inject constructor(val api: BooksAPI) {

    private var bookList: List<Book> = listOf()

    fun getBooks(forceUpdate: Boolean = false): Observable<List<Book>> {

        return if (bookList.isEmpty() || forceUpdate) {
            api.getBooks().map {
                bookList = it
                return@map it
            }.onErrorReturn {
                Log.e("MODEL", it.message + "")
                return@onErrorReturn listOf()
            }
        }
        else {
            Observable.just(bookList)
        }
    }
}