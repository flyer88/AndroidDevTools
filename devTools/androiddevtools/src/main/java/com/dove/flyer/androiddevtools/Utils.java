package com.dove.flyer.androiddevtools;

import android.annotation.SuppressLint;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.annotation.StringRes;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.dove.flyer.androiddevtools.webViewHelper.JsExecInterface;

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

    public static void execJs(WebView webView,String jsCode){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            webView.evaluateJavascript(jsCode, new ValueCallback<String>() {
                @Override
                public void onReceiveValue(String s) {

                }
            });
        } else {
            webView.loadUrl("javascript:" + jsCode);
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static void execJs(WebView webView, String jsCode, final JsExecInterface.JsEvaluateCallback callback){
        webView.evaluateJavascript(jsCode, new ValueCallback<String>() {
            @Override
            public void onReceiveValue(String s) {
                callback.onResult(s);
            }
        });
    }
}
