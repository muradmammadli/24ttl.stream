package com.example.a24ttlstream

import android.annotation.SuppressLint
import android.webkit.WebView

object Test {

    @SuppressLint("SetJavaScriptEnabled")
    fun loadHtmlContent(webView: WebView, htmlContent: String) {
        webView.settings.javaScriptEnabled = true
        webView.loadDataWithBaseURL(null, htmlContent, "text/html", "UTF-8", null)
    }
}