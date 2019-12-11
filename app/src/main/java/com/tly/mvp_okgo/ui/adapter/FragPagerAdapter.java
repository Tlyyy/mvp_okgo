package com.tly.mvp_okgo.ui.adapter;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

/**
 * @describe ViewPager+Fragment 的适配器
 * @Author TLY
 * @Email 510133020@qq.com
 * @Time 2019/5/9 on 16:13
 * @Company *宁波健新智能*
 */
public class FragPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> mFragments;

    public FragPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        mFragments = fragments;

    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
}

