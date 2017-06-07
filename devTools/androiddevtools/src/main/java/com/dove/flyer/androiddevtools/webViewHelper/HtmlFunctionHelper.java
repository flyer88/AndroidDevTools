package com.dove.flyer.androiddevtools.webViewHelper;

/**
 * Created by flyer on 2017/6/6.
 */

public class HtmlFunctionHelper {

    public final static String CREATE_ELEMENT = "createElement";
    public final static String BODY = "body";

    public static HtmlElement createElement(HtmlElement document, String elementName, String elmentId){
        document.execAttrs(CREATE_ELEMENT + "(" + elementName+ ")");
        return document;
    }


}
