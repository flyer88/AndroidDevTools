package com.zmsoft.devtools;

import android.annotation.SuppressLint;
import android.os.Build;
import android.webkit.WebSettings;
import android.webkit.WebView;

/**
 * Created by flyer on 2017/6/6.
 */

public class Utils {

    @SuppressLint("SetJavaScriptEnabled")
    public static WebView initDefaultWebView(WebView webView){
        WebSettings webSettings = webView.getSettings();
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setSupportZoom(true);
        webSettings.setDisplayZoomControls(false);
        webSettings.setBuiltInZoomControls(true);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        return webView;
    }
}
