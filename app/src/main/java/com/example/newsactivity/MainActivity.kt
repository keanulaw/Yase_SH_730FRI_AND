package com.example.newsactivity

import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), ArticleListFragment.OnArticleSelectedListener {

    private var isLandscape = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        isLandscape = resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(if (isLandscape) R.id.headline_container else R.id.fragment_container, ArticleListFragment())
                .commit()
        }
    }

    override fun onArticleSelected(article: Article) {
        val contentFragment = ArticleContentFragment.newInstance(article.headline, article.content)

        if (isLandscape) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.content_container, contentFragment)
                .commit()
        } else {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, contentFragment)
                .addToBackStack(null)
                .commit()
        }
    }
}
