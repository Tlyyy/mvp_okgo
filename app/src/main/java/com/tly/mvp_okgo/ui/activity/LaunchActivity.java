package com.tly.mvp_okgo.ui.activity;

import android.content.Intent;
import android.os.Bundle;

import com.zhy.autolayout.AutoLayoutActivity;

import static java.lang.Thread.sleep;


/**
 * @describe 启动页
 * @Author TLY
 * @Email 510133020@qq.com
 * @Time 2019/5/15 on 15:09
 * @Company *宁波健新智能*
 */
public class LaunchActivity extends AutoLayoutActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new Thread(new Runnable() {

            @Override
            public void run() {
                //耗时任务，比如加载网络数据
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            sleep(1500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        // 这里可以睡几秒钟，如果要放广告的话
                        startActivity(new Intent(LaunchActivity.this, MainActivity.class));
                        finish();
                    }
                });
            }
        }).start();

    }
}
