package com.dove.flyer.androiddevtools.webViewHelper;

/**
 * Created by flyer on 2017/6/6.
 */

public interface JsExecInterface<T> {

    interface JsEvaluateCallback{
        void onResult(String value);
    }

    /**
     * 获取 T 下的属性到 java 环境中
     * @param attrs 属性名字
     * @return 当前对象
     */
    void getAttrsValue(String attrs,JsEvaluateCallback jsEvaluateCallback);
    /**
     * 在 js 环境中设置 T 下的属性的值
     * @param attrs 属性名字
     * @param value 属性值
     * @return 当前对象
     */
    T setAttrsValue(String attrs, String value);

    /**
     * 在 js 环境下运行 T 下的属性
     * @param attrs 属性名字
     * @return 当前对象
     */
    T execAttrs(String attrs);

    /**
     *
     * @return 获取当前运行的属性整行调用链
     */
    String getCurAttrsChain();

    /**
     *
     * @return 设置当前运行的属性整行调用链
     */
    T setCurAttrsChain(String attrs);

    /**
     *
     * @param shortName 属性的短名字
     * @param attrs 运行的属性的全称
     */
    void exec(String shortName,String attrs);

    /**
     *
     * @param shortName 属性的短名字
     * @param attrs 运行的属性的全称
     * @param jsEvaluateCallback 运行结果的回调
     */
    void exec(String shortName,String attrs,JsEvaluateCallback jsEvaluateCallback);
}
