package com.project.newsapp.ui.fragments

import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.project.newsapp.R
import com.project.newsapp.models.Article
import com.project.newsapp.ui.NewsActivity
import com.project.newsapp.ui.NewsViewModel
import kotlinx.android.synthetic.main.fragment_article.webView

class ArticleFragment : Fragment(R.layout.fragment_article){
    lateinit var viewModel: NewsViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as NewsActivity).newsViewModel
        val article = arguments?.getSerializable("article") as Article?
        webView.apply {
            webViewClient = WebViewClient()
            if (article != null) {
                loadUrl(article.url)
            }
        }
    }
}