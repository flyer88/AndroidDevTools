package com.dove.flyer.androiddevtools.webViewHelper;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.webkit.WebView;

import com.dove.flyer.androiddevtools.Utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by flyer on 2017/6/7.
 */

public class JsObject implements JsExecInterface<JsObject>{

    final static String VAR = "var ";
    WebView mWebView;
    String  mName;
    String mDeclaration;
    String mCurAttrsChain;
    String mObject;
    private Map<String,String> mAttrsMap = new HashMap<>();

    public JsObject(WebView webView,String objectName){
        this.mWebView = webView;
        this.mName = objectName;
        this.mDeclaration = VAR + objectName;
        Utils.execJs(mWebView,mDeclaration);
    }

    /**
     * 会清除原来的对象 string
     * @param json
     */
    public void setValues(String json){
        mObject = "";
        if (!json.startsWith("{")) json = "{" + json;
        if (!json.endsWith("}")) json = json + "}";
        mObject = mName + "=" + json;
        Utils.execJs(mWebView,mObject);
    }

    @Override
    public void getAttrsValue(String attrs, JsEvaluateCallback jsEvaluateCallback) {

    }

    @Override
    public JsObject setAttrsValue(String attrs, String value) {
        mCurAttrsChain = mName +  "." + attrs + "=" + value;
        exec(attrs,mCurAttrsChain);
        return this;
    }

    @Override
    public JsObject execAttrs(String attrs) {
        this.mCurAttrsChain = mName + "." + attrs;
        exec(attrs,mCurAttrsChain);
        return this;
    }

    public String getCurAttrsChain() {
        return mCurAttrsChain;
    }

    public JsObject setCurAttrsChain(String attrs) {
        mCurAttrsChain = attrs;
        return this;
    }

    @Override
    public void exec(String shortName, String attrs) {
        mAttrsMap.put(shortName,attrs);
        Utils.execJs(mWebView,attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void exec(String shortName, String attrs, JsEvaluateCallback jsEvaluateCallback) {
        mAttrsMap.put(shortName,attrs);
        Utils.execJs(mWebView,attrs,jsEvaluateCallback);
    }
}
