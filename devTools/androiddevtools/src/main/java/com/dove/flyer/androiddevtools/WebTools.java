package com.dove.flyer.androiddevtools;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.webkit.WebView;

/**
 * Created by dove on 2017/6/6.
 */

public class WebTools {

    private Context mContext;
    private ViewGroup mParentView;
    private WebView mWebView;
    private JsonView mJsonView;
    private boolean mIsShow;


    public WebTools(Context context,ViewGroup parentView){
        this.mContext = context;
        this.mParentView = parentView;
        init(false);
    }
    public WebTools(Context context,ViewGroup parentView,boolean show){
        this.mContext = context;
        this.mParentView = parentView;
        init(show);
    }


    @SuppressLint("SetJavaScriptEnabled")
    private void init(boolean attach){
        if (mWebView == null)
            mWebView = (WebView) LayoutInflater.from(mContext).inflate(R.layout.json_view,mParentView,false);
        if (attach && mWebView.getParent() == null)
            mParentView.addView(mWebView);
        Utils.initDefaultWebView(mWebView);
    }

    public WebTools addJsonView(){
        if (mJsonView == null) mJsonView = new JsonView(this);
        return this;
    }
    public WebTools addJsonView(String json){
        if (mJsonView == null) mJsonView = new JsonView(this);
        mJsonView.loadJson(json);
        return this;
    }






    public WebView getWebView() {
        return mWebView;
    }

    public ViewGroup getParentView() {
        return mParentView;
    }

    public JsonView getJsonView() {
        return mJsonView;
    }

    public Context getContext() {
        return mContext;
    }

    public boolean isShow() {
        return mIsShow;
    }
}
