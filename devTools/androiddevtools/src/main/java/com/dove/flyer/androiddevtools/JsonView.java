package com.dove.flyer.androiddevtools;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.dove.flyer.androiddevtools.webViewHelper.HtmlElementTable;
import com.dove.flyer.androiddevtools.webViewHelper.HtmlFunctionHelper;
import com.dove.flyer.androiddevtools.webViewHelper.HtmlElement;
import com.dove.flyer.androiddevtools.webViewHelper.JsFunction;
import com.dove.flyer.androiddevtools.webViewHelper.JsObject;

/**
 * Created by dove on 2017/6/6.
 */

public class JsonView {
    private Context mContext;
    private ViewGroup mParentView;
    private WebView mWebView;
    private boolean mIsShow;
    private WebTools mWebTools;

    /**
     * webTools 添加 JsonView 组件
     * @param webTools
     */
    public JsonView(WebTools webTools){
        this(webTools.getContext(),webTools.getParentView(),webTools.isShow(), true);
        this.mWebTools = webTools;
    }

    /**
     * 直接使用 JsonView 组件
     * @param context 用来 LayoutInflate
     * @param parentView 用来 webView attach 的
     */
    public JsonView(Context context,ViewGroup parentView){
        this.mContext = context;
        this.mParentView = parentView;
        mIsShow = false;
        init(mIsShow,false);
    }

    /**
     * 最终的构造函数
     * @param context
     * @param parentView
     * @param show 是否要立刻展示到父级布局上
     * @param hasInit webView 是否有过默认的初始化
     */
    public JsonView(Context context,ViewGroup parentView,boolean show,boolean hasInit){
        this.mContext = context;
        this.mParentView = parentView;
        mIsShow = show;
        init(mIsShow,hasInit);
    }

    /**
     * 初始化方法
     * @param attach 是否要展示到父级 view 上
     * @param hasInit 是否有初始化过 webView
     */
    private void init(boolean attach,boolean hasInit){
        if (mWebView == null)
            mWebView = (WebView) LayoutInflater.from(mContext).inflate(R.layout.json_view,mParentView,false);
        if (attach && mWebView.getParent() == null) {
            mParentView.addView(mWebView);
        }
        if (!hasInit) Utils.initDefaultWebView(mWebView);
        // 载入本地的 jsonView 的 html
        mWebView.loadUrl("file:///android_asset/JsonView.html");
    }

    /**
     * 载入数据
     * @param json 载入的 json 数据
     * @return 当前对象
     */
    public JsonView loadJson(String json){
        if (!mIsShow) {
            mParentView.addView(mWebView);
            mIsShow = true;
        }
        execJavaScript(mWebView,json);
        return this;
    }

    /**
     * 构建载入数据和载入方法整个命令代码字符串
     * @param json 需要展示的 json 数据
     * @return 构建出的 js 对象和方法
     */
    void execJavaScript(WebView webView,String json){
        if (!json.startsWith("{")) json = "{" + json;
        if (!json.endsWith("}")) json = json + "}";
        JsObject jsObject = new JsObject(webView,"nativeJsonData");
        jsObject.setValues(json);
        JsFunction jsFunction = new JsFunction(webView,"showJSONView","$(\"#json\").JSONView(nativeJsonData);");
        jsFunction.exec();
    }

    public WebTools getWebTools() {
        return mWebTools;
    }

    public WebView getWebView() {
        return mWebView;
    }
}
