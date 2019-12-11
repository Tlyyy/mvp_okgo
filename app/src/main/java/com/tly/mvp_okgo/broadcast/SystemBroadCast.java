package com.tly.mvp_okgo.broadcast;

import com.tencent.mmkv.MMKV;

/**
 * @describe 扫描条码的广播
 * @Author TLY
 * @Email 510133020@qq.com
 * @Time 2019-12-04 on 09:40
 * @Company *宁波健新智能*
 */
public class SystemBroadCast {
    private static MMKV kv = MMKV.defaultMMKV();
    public static final String PDA_TYPE = kv.decodeString("PDA_TYPE");
    //扫描条码服务广播
    public static final String SCN_CUST_ACTION_SCODE=kv.decodeString("SCN_CUST_ACTION_SCODE");
    //条码扫描数据广播
    public static final String SCN_CUST_EX_SCODE=kv.decodeString("SCN_CUST_EX_SCODE");
}
