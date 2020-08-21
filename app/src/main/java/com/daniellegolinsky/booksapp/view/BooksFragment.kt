package com.daniellegolinsky.booksapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.daniellegolinsky.booksapp.R
import com.daniellegolinsky.booksapp.dagger.ViewModelProviderFactory
import com.daniellegolinsky.booksapp.databinding.BooksListBinding
import com.daniellegolinsky.booksapp.model.Book
import com.daniellegolinsky.booksapp.viewmodel.BooksViewModel
import dagger.android.support.DaggerFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class BooksFragment @Inject constructor() : DaggerFragment() {

    @Inject
    lateinit var viewModelProviderFactory: ViewModelProviderFactory
    lateinit var viewModel: BooksViewModel

    lateinit var recyclerView: RecyclerView
    lateinit var viewAdapter: BooksRecyclerViewAdapter

    lateinit var layoutBinding: BooksListBinding

    var compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProviders.of(this, viewModelProviderFactory).get(BooksViewModel::class.java)
        viewModel.updateList()
        viewAdapter = BooksRecyclerViewAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        layoutBinding = DataBindingUtil.inflate(inflater,
                                                R.layout.books_list,
                                                container,
                                 false)
        layoutBinding.lifecycleOwner = this
        layoutBinding.viewModel = viewModel
        layoutBinding.executePendingBindings()

        recyclerView = layoutBinding.root.findViewById(R.id.books_list)
        recyclerView.adapter = viewAdapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        compositeDisposable.add(viewModel.updateList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { updateList(it) }
        )

        return layoutBinding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()
    }

    private fun updateList(list: List<Book>) {
        viewAdapter.setList(list)
        layoutBinding.invalidateAll()
    }

}