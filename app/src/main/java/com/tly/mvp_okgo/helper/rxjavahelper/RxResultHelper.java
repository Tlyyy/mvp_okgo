package com.tly.mvp_okgo.helper.rxjavahelper;


import android.annotation.SuppressLint;
import android.content.Context;


import com.tly.mvp_okgo.mode.BaseResponseData;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.functions.Function;

/**
 * @describe Rx处理服务器返回,
 * *      服务器的返回的数据格式一般都是一致的，所有我们每个网络请求都可以使
 * *      用compose(RxResultHelper.handleResult())来处理服务器返回，一般服务器返回成功码为200，
 * *      相应改一下返回码的判断就行了
 * @Author TLY
 * @Email 510133020@qq.com
 * @Time 2019/5/10 on 15:17
 * @Company *宁波健新智能*
 */
public class RxResultHelper {
    private static final int RESPONSE_SUCCESS_CODE = 0; //
    private static final int RESPONSE_NO_BARCODE_INFO = 2; //条码不存在
    private static final int RESPONSE_NO_BARCODE_ERO = 3; //条码不存在
    private static final int RESPONSE_REQUEST_PARAMETER_ERO = 1; //请求参数错误
    private static final int RESPONSE_NO_TOKEN = 4001; //请求参数错误

    @SuppressLint("StaticFieldLeak")
    private static Context mContext;
    private static final int RESPONSE_SUCCESS_CODE_W = 1001; //
    private static final int RESPONSE_DIFFERENT_VENDOR = 1002; //购单号不是来自同一厂商
    private static final int RESPONSE_ERROR_CODE = -1;

    public static <T> ObservableTransformer<BaseResponseData<T>, T> handleResult() {

        return new ObservableTransformer<BaseResponseData<T>, T>() {
            @Override
            public ObservableSource<T> apply(Observable<BaseResponseData<T>> tObservable) {
                return tObservable.flatMap(
                        new Function<BaseResponseData<T>, Observable<T>>() {
                            @Override
                            public Observable<T> apply(BaseResponseData<T> tBaseResponseData) throws Exception {
                                //可以相应更改
                                switch (tBaseResponseData.getCode()) {
                                    case RESPONSE_SUCCESS_CODE:
                                        return Observable.just(tBaseResponseData.getData());
                                    case RESPONSE_SUCCESS_CODE_W:
                                        return Observable.just(tBaseResponseData.getData());
                                    case RESPONSE_NO_BARCODE_INFO:
                                        return Observable.error(new Exception(tBaseResponseData.getMessage()));
                                    case RESPONSE_NO_BARCODE_ERO:
                                        return Observable.error(new Exception(tBaseResponseData.getMessage()));
                                    case RESPONSE_DIFFERENT_VENDOR:
                                        return Observable.error(new Exception(tBaseResponseData.getMessage()));
                                    case RESPONSE_REQUEST_PARAMETER_ERO:
                                        return Observable.error(new Exception(tBaseResponseData.getMessage()));
                                    case RESPONSE_NO_TOKEN:
                                        return Observable.error(new Exception("Token_Expired"));
                                    default:
                                        return Observable.empty();
                                }
                            }
                        }
                );
            }

        };
    }


}
