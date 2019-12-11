package com.tly.mvp_okgo.ui.fragment;

import com.tly.mvp_okgo.R;
import com.tly.mvp_okgo.ui.base.BaseFragment;
import com.tly.mvp_okgo.ui.base.BasePresenter;

/**
 * @describe
 * @Author TLY
 * @Email 510133020@qq.com
 * @Time 2019-12-04 on 11:12
 * @Company *宁波健新智能*
 */
public class UserFragment extends BaseFragment {
    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.fragment__user;
    }
    public static UserFragment newInstance() {
        return new UserFragment();
    }
}
