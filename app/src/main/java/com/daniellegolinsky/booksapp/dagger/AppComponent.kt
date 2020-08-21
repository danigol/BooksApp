package com.daniellegolinsky.booksapp.dagger

import com.daniellegolinsky.booksapp.BooksApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [ AndroidSupportInjectionModule::class,
                AppModule::class,
                ActivityModule::class ]
)
interface AppComponent : AndroidInjector<BooksApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: BooksApplication) : Builder
        fun build(): AppComponent
    }
}