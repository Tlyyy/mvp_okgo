package com.tly.mvp_okgo.mode;

import java.io.Serializable;


/**
 * @describe ResponseData基类
 * @Author TLY
 * @Email 510133020@qq.com
 * @Time 2019/5/13 on 8:39
 * @Company *宁波健新智能*
 */
public class BaseResponseData<T> implements Serializable {
    private int code;
    private String message;
    private String state;
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
