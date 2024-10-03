package com.example.newsactivity

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.ListFragment

class ArticleListFragment : ListFragment() {

    private lateinit var callback: OnArticleSelectedListener
    // Initialize articleList with an empty mutable list (no lateinit)
    private var articleList: MutableList<Article> = mutableListOf()

    interface OnArticleSelectedListener {
        fun onArticleSelected(article: Article)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        callback = context as OnArticleSelectedListener
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // Populating the articleList
        val articleList = mutableListOf(
            Article("City Introduces New Public Transit System", "The city's new electric buses aim to reduce traffic and pollution."),
            Article("Groundbreaking Cancer Research Published", "Scientists release new findings that could revolutionize cancer treatment."),
            Article("Community Garden Program Expands", "Local residents can now apply for free plots in the city's new community garden initiative."),
            Article("Major Software Update Released", "SoftTech releases an update that improves security and adds new features to their operating system."),
            Article("Annual Music Festival Kicks Off This Weekend", "The much-anticipated festival returns with an exciting lineup of local and international artists.")
        )


        // Converting to java.util.List to match ListFragment requirements
        val javaArticleList: ArrayList<Article> = ArrayList(articleList)

        // Set the list adapter
        setListAdapter(ArrayAdapter(requireActivity(), android.R.layout.simple_list_item_1, javaArticleList))
    }

    override fun onListItemClick(l: ListView, v: View, position: Int, id: Long) {
        // Ensure type safety
        callback.onArticleSelected(articleList[position])
    }
}
