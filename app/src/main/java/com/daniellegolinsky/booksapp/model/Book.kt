package com.daniellegolinsky.booksapp.model

import java.io.Serializable

class Book : Serializable{

    var id: Int = -1
    var author: String = ""
    var categories: String = ""
    var title: String = ""
}
