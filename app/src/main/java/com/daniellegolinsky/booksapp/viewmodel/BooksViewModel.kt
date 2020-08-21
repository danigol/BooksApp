package com.daniellegolinsky.booksapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.daniellegolinsky.booksapp.model.Book
import com.daniellegolinsky.booksapp.model.BookListModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class BooksViewModel @Inject constructor(var model: BookListModel): ViewModel() {

    fun updateList(): Observable<List<Book>> {
        return model.getBooks(true).doOnError { Log.e("VIEWMODEL", "Error: ${it?.message}") }
    }

    fun addBookClicked() {

    }

}