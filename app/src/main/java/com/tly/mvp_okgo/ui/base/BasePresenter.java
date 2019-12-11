package com.tly.mvp_okgo.ui.base;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * @describe Presenter 基类
 * @Author TLY
 * @Email 510133020@qq.com
 * @Time 2019/5/14 on 14:49
 * @Company *宁波健新智能*
 */
public abstract class BasePresenter<V> {
    protected Reference<V> mViewRef;


    public void attachView(V view){
        mViewRef = new WeakReference<V>(view);
    }

    protected V getView(){
        return mViewRef.get();
    }

    public boolean isViewAttached(){
        return mViewRef != null&&mViewRef.get()!=null;
    }

    public void detachView(){
        if(mViewRef!=null){
            mViewRef.clear();
            mViewRef = null;
        }
    }
}
