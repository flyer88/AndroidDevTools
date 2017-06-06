package com.zmsoft.devtools;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

/**
 * Created by dove on 2017/6/6.
 */

public class JsonView {
    private Context mContext;
    private ViewGroup mParentView;
    private WebView mWebView;

    public JsonView(Context context,ViewGroup parentView){
        this.mContext = context;
        this.mParentView = parentView;
        init(false);
    }
    public JsonView(Context context,ViewGroup parentView,boolean show){
        this.mContext = context;
        this.mParentView = parentView;
        init(show);
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void init(boolean attach){
        mWebView = (WebView) LayoutInflater.from(mContext).inflate(R.layout.json_view,mParentView,false);
        mParentView.addView(mWebView);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setJavaScriptEnabled(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        mWebView.loadUrl("file:///android_asset/JsonView.html");
    }

    public void loadJson(String json){

    }

    public void setRequestPath(){

    }


}
