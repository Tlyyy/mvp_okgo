package com.tly.mvp_okgo.util.drag;

import com.alibaba.fastjson.JSON;

/**
 * @describe
 * @Author TLY
 * @Email 510133020@qq.com
 * @Time 2019-10-23 on 15:58
 * @Company *宁波健新智能*
 */
public class JsonUtils {
//    static {
//        TypeUtils.compatibleWithJavaBean = true;
//    }

    public static String parseJson(Object obj) {
        return JSON.toJSONString(obj);
    }

}
