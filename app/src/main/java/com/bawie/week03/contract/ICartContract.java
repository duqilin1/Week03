package com.bawie.week03.contract;

import com.bawie.week03.model.bean.CartBean;

/*
 *@auther:杜其林
 *@Date: 2020/1/11
 *@Time:10:38
 *@Description:${DESCRIPTION}
 * */
public interface ICartContract {

    interface IView{
        void onCartSeccess(CartBean cartBean);
        void onCartFailure(Throwable throwable);
    }

    interface IPresenter{
        void getCartData();
    }

    interface IModel{
        void getCartData(IModelCallback iModelCallback);

        interface IModelCallback{
            void onCartSeccess(CartBean cartBean);
            void onCartFailure(Throwable throwable);
        }
    }
}
