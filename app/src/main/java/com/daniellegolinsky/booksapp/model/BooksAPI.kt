package com.daniellegolinsky.booksapp.model

import io.reactivex.Observable
import retrofit2.http.GET

interface BooksAPI {

    @GET("books")
    fun getBooks(): Observable<List<Book>>
}