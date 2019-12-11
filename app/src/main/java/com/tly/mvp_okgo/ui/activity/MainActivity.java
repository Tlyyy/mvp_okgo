package com.tly.mvp_okgo.ui.activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.blankj.utilcode.util.ToastUtils;
import com.tly.mvp_okgo.R;
import com.tly.mvp_okgo.app.App;
import com.tly.mvp_okgo.ui.adapter.FragPagerAdapter;
import com.tly.mvp_okgo.ui.base.BaseActivity;
import com.tly.mvp_okgo.ui.base.BasePresenter;
import com.tly.mvp_okgo.ui.fragment.HomeFragment;
import com.tly.mvp_okgo.ui.fragment.UserFragment;
import com.tencent.mmkv.MMKV;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @describe MainActivity
 * @Author TLY
 * @Email 510133020@qq.com
 * @Time 2019/5/14 on 15:14
 * @Company *宁波健新智能*
 */
public class MainActivity extends BaseActivity {

    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.home_iv)
    ImageView homeIv;
    @BindView(R.id.tv_home)
    TextView tvHome;
    @BindView(R.id.ll_home)
    LinearLayout llHome;
    @BindView(R.id.my_iv)
    ImageView myIv;
    @BindView(R.id.tv_user)
    TextView tvUser;
    @BindView(R.id.ll_user)
    LinearLayout llUser;

    MMKV kv = MMKV.defaultMMKV();
    private List<Fragment> mFragments = new ArrayList<>();
    private long secondTime = 0;
    private long firstTime = 0;

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    public void init() {
        MMKV.initialize(this);//

    }

    @Override
    public void initView() {
        changeSelectedState(0);//默认选中首页
        mFragments.add(HomeFragment.newInstance());
        mFragments.add(UserFragment.newInstance());

        viewpager.setAdapter(new FragPagerAdapter(getSupportFragmentManager(), mFragments));
        viewpager.setCurrentItem(0, true);//默认选中首页
        viewpager.setOffscreenPageLimit(3);
        viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
            }

            @Override
            public void onPageSelected(int i) {
                switch (i) {
                    case 0:
                        changeSelectedState(0);
                        break;
                    case 1:
                        changeSelectedState(1);
                        break;
                    case 2:
                        changeSelectedState(2);
                        break;

                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    @Override
    public void initData() {

        String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.CAMERA};
        if (Build.VERSION.SDK_INT >= 23) {
            int REQUEST_CODE_CONTACT = 101;
            //验证是否许可权限
            for (String str : permissions) {
                if (MainActivity.this.checkSelfPermission(str) != PackageManager.PERMISSION_GRANTED) {
                    //申请权限
                    MainActivity.this.requestPermissions(permissions, REQUEST_CODE_CONTACT);
                }
            }
        }
    }

    @OnClick({R.id.ll_home, R.id.ll_user})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_home:
                viewpager.setCurrentItem(0);
                changeSelectedState(0);
                break;
            case R.id.ll_user:
                viewpager.setCurrentItem(2);
                changeSelectedState(2);
                break;
        }
    }

    private void changeSelectedState(int position) {

        if (position == 0) {
            homeIv.setSelected(true);
            tvHome.setSelected(true);
            myIv.setSelected(false);
            tvUser.setSelected(false);
        } else if (position == 1) {
            homeIv.setSelected(false);
            tvHome.setSelected(false);
            myIv.setSelected(false);
            tvUser.setSelected(false);
        } else if (position == 2) {
            homeIv.setSelected(false);
            tvHome.setSelected(false);
            myIv.setSelected(true);
            tvUser.setSelected(true);
        }
    }

    /**
     * 退出事件
     *
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            hideWaitingDialog();
            secondTime = System.currentTimeMillis();
            if (secondTime - firstTime > 1000) {//如果两次按键时间间隔大于1000毫秒，则不退出 
                ToastUtils.showShort("再按一次退出程序");
                firstTime = secondTime;//更新firstTime 
                return true;
            } else {
                App.exit();
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}






