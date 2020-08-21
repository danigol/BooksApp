package com.daniellegolinsky.booksapp.dagger

import androidx.lifecycle.ViewModel
import com.daniellegolinsky.booksapp.viewmodel.BooksViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class BooksViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(BooksViewModel::class)
    abstract fun bindBooksViewModel(vm: BooksViewModel) : ViewModel
}