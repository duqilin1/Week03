package com.bawie.week03.model;

import com.bawie.week03.contract.ICartContract;
import com.bawie.week03.model.bean.CartBean;
import com.bawie.week03.util.NetUtil;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/*
 *@auther:杜其林
 *@Date: 2020/1/11
 *@Time:10:50
 *@Description:${DESCRIPTION}
 * */
public class CartModel implements ICartContract.IModel {

    @Override
    public void getCartData(IModelCallback iModelCallback) {
        NetUtil.getInstance().getApi().cartBean("13110","157873063730513110")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CartBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CartBean cartBean) {
                        iModelCallback.onCartSeccess(cartBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallback.onCartFailure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
