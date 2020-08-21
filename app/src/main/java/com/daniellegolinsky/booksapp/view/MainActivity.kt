package com.daniellegolinsky.booksapp.view

import android.os.Bundle
import com.daniellegolinsky.booksapp.R
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : DaggerAppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var fragmentContainer: Int = R.id.books_list_fragment_container
        supportFragmentManager.beginTransaction()
            .replace(fragmentContainer, BooksFragment(), null)
            .commit()
    }
}