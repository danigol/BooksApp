package com.daniellegolinsky.booksapp.dagger

import com.daniellegolinsky.booksapp.view.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector(
        modules = [
            FragmentModule::class,
            BooksViewModelModule::class
        ]
    )
    abstract fun contributesMainActivity(): MainActivity
}