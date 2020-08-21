package com.daniellegolinsky.booksapp

import com.daniellegolinsky.booksapp.dagger.AppComponent
import com.daniellegolinsky.booksapp.dagger.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class BooksApplication : DaggerApplication() {
    companion object {
        lateinit var component: AppComponent
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        component = DaggerAppComponent.builder().application(this).build()
        return component
    }

}