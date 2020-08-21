package com.daniellegolinsky.booksapp.dagger

import com.daniellegolinsky.booksapp.view.BooksFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {
    @ContributesAndroidInjector(
        modules = [ BooksViewModelModule::class ]
    )
    abstract fun contributesBooksFragment(): BooksFragment

}