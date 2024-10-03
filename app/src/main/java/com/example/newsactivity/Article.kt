package com.example.newsactivity

data class Article(val headline: String, val content: String) {
    override fun toString(): String {
        return headline
    }
}
