package com.bawie.week03.presenter;

import com.bawie.week03.contract.ICartContract;
import com.bawie.week03.model.bean.CartBean;
import com.bawie.week03.base.BasePresenter;
import com.bawie.week03.model.CartModel;

/*
 *@auther:杜其林
 *@Date: 2020/1/11
 *@Time:10:49
 *@Description:${DESCRIPTION}
 * */
public class CartPresenter extends BasePresenter<ICartContract.IView> implements ICartContract.IPresenter{

    private CartModel cartModel;

    @Override
    protected void initModel() {
        cartModel = new CartModel();
    }

    @Override
    public void getCartData() {
        cartModel.getCartData(new ICartContract.IModel.IModelCallback() {
            @Override
            public void onCartSeccess(CartBean cartBean) {
                view.onCartSeccess(cartBean);
            }

            @Override
            public void onCartFailure(Throwable throwable) {
                view.onCartFailure(throwable);
            }
        });
    }
}
