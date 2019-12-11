package com.tly.mvp_okgo.helper.rxjavahelper;


import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @describe 自己的Observer，减少实现不必要的回调
 * @Author TLY
 * @Email 510133020@qq.com
 * @Time 2019/5/10 on 15:16
 * @Company *宁波健新智能*
 */
public abstract class RxObserver<T> implements Observer<T> {
    public void onSubscribe(Disposable d) {
        _onSubscribe(d);
    }

    public void onNext(T t) {
        _onNext(t);
    }

    @Override
    public void onError(Throwable e) {
        _onError(e.getMessage());
    }

    public void onComplete() {
        _onComplete();
    }




    public void _onSubscribe(Disposable d) {

    }

    public void _onComplete() {

    }

    //抽象方法，必须实现
    public abstract void _onNext(T t);

    public abstract void _onError(String errorMessage);

}
