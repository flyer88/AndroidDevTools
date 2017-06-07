package com.dove.flyer.androiddevtools.webViewHelper;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.webkit.WebView;

import com.dove.flyer.androiddevtools.Utils;

/**
 * Created by flyer on 2017/6/7.
 */

public class JsFunction {

    private WebView mWebView;
    private String mFuncName;
    private String mFuncBody;
    private String mFunction;

    public JsFunction(WebView webView,String funcName,String funcBody){
        this.mWebView = webView;
        this.mFuncName = funcName;
        this.mFuncBody = funcBody;
        mFunction = "function " + mFuncName + "()" + "{" +  mFuncBody + "}";
        Utils.execJs(mWebView,mFunction);
    }

    public void exec(){
        String exec = mFuncName + "()";
        Utils.execJs(mWebView,exec);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void exec(JsExecInterface.JsEvaluateCallback callback){
        String exec = mFuncName + "()";
        Utils.execJs(mWebView,exec,callback);
    }
}
