package com.example.webviewtest;


import android.os.Build;
import android.os.Bundle;

import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView webView = (WebView)findViewById(R.id.web_view);
        mWebView = webView;

        webView.getSettings().setDefaultTextEncodingName("utf-8") ;
        webView.getSettings().setDomStorageEnabled(true);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setCacheMode(webView.getSettings().LOAD_NO_CACHE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            webView.setWebContentsDebuggingEnabled(true);
        }

        mWebView.loadUrl("file:///android_asset/html/index.html");
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }
        });
    }
}
