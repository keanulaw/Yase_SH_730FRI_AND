package com.example.newsactivity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class ArticleContentFragment : Fragment() {
    companion object {
        private const val ARG_HEADLINE = "headline"
        private const val ARG_CONTENT = "content"

        fun newInstance(headline: String, content: String): ArticleContentFragment {
            val fragment = ArticleContentFragment()
            val args = Bundle()
            args.putString(ARG_HEADLINE, headline)
            args.putString(ARG_CONTENT, content)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_article_content, container, false)
        arguments?.let {
            val headline = it.getString(ARG_HEADLINE)
            val content = it.getString(ARG_CONTENT)
            view.findViewById<TextView>(R.id.news_headline).text = headline
            view.findViewById<TextView>(R.id.news_content).text = content
        }
        return view
    }
}
