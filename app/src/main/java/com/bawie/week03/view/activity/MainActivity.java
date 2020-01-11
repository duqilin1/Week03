package com.bawie.week03.view.activity;

import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.ImageView;

import com.bawie.week03.R;
import com.bawie.week03.base.BaseActivity;
import com.bawie.week03.contract.ICartContract;
import com.bawie.week03.model.bean.CartBean;
import com.bawie.week03.presenter.CartPresenter;
import com.bawie.week03.view.adapter.CartAdapter;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity<CartPresenter> implements ICartContract.IView {


    @BindView(R.id.img)
    ImageView img;
    @BindView(R.id.elv_list)
    ExpandableListView elvList;

    @Override
    protected void initData() {
        String stringExtra = getIntent().getStringExtra("key");
        Glide.with(img).load(stringExtra).into(img);
        mPresenter.getCartData();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected CartPresenter providePresenter() {
        return new CartPresenter();
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onCartSeccess(CartBean cartBean) {
        List<CartBean.ResultBean> result = cartBean.getResult();
        CartAdapter cartAdapter = new CartAdapter(result);
        elvList.setAdapter(cartAdapter);
    }

    @Override
    public void onCartFailure(Throwable throwable) {

    }
}
