package com.dove.flyer.androiddevtools.webViewHelper;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.webkit.WebView;

import com.dove.flyer.androiddevtools.Utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by flyer on 2017/6/6.
 */

public class HtmlElement implements JsExecInterface<HtmlElement> {

    private static String ELEMENT_NAME = "window.";

    WebView mWebView;

    private Map<String,String> mAttrsMap = new HashMap<>();

    private String mCurAttrsChain = ELEMENT_NAME;

    public HtmlElement(WebView webView, String elementName){
        this.mWebView = webView;
        ELEMENT_NAME = elementName;
    }


    @Override
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void getAttrsValue(String attrs, JsEvaluateCallback jsEvaluateCallback) {
        mCurAttrsChain = ELEMENT_NAME + attrs;
        exec(attrs, mCurAttrsChain,jsEvaluateCallback);
    }

    @Override
    public HtmlElement setAttrsValue(String attrs, String value) {
        mCurAttrsChain = ELEMENT_NAME + attrs + "=" + value;
        exec(attrs, mCurAttrsChain);
        return this;
    }

    @Override
    public HtmlElement execAttrs(String attrs) {
        this.mCurAttrsChain = ELEMENT_NAME + attrs;
        exec(attrs, mCurAttrsChain);
        return this;
    }

    public String getCurAttrsChain() {
        return mCurAttrsChain;
    }

    public HtmlElement setCurAttrsChain(String curAttrsChain) {
        this.mCurAttrsChain = curAttrsChain;
        return this;
    }


    @Override
    public void exec(String shortName, String attrs) {
        mAttrsMap.put(shortName,attrs);
        Utils.execJs(mWebView, mCurAttrsChain);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void exec(String shortName, String attrs, JsEvaluateCallback jsEvaluateCallback) {
        mAttrsMap.put(shortName,attrs);
        Utils.execJs(mWebView, mCurAttrsChain,jsEvaluateCallback);
    }

    public HtmlElement createJSObject(String curElement){
        HtmlElement htmlJsObj = new HtmlElement(mWebView,curElement);
        return htmlJsObj;
    }
}
