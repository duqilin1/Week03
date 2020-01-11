package com.bawie.week03.contract;

import com.bawie.week03.model.bean.LoginBean;
import com.bawie.week03.model.bean.ZhuCeBean;

/*
 *@auther:杜其林
 *@Date: 2020/1/11
 *@Time:13:40
 *@Description:${DESCRIPTION}
 * */
public interface ILoginContract {

    interface IView {
        //登录
        void onLoginSuccess(LoginBean loginBean);
        void onLoginFailure(Throwable throwable);

        //注册
        void onZhuCeSuccess(ZhuCeBean zhuCeBean);
        void onZhuCeFailure(Throwable throwable);
    }

    interface IPresenter {
        //登录
        void getLoginData(String phone,String pwd);
        //注册
        void getZhuCeData(String phone,String pwd);
    }

    interface IModel {
        //登录
        void getLoginData(String phone,String pwd,ILoginModelCallBack iLoginModelCallBack);
        //注册
        void getZhuCeData(String phone,String pwd,IZhuCeModelCallBack iZhuCeModelCallBack);

        interface ILoginModelCallBack {
            //登录
            void onLoginSuccess(LoginBean loginBean);
            void onLoginFailure(Throwable throwable);
        }
        interface IZhuCeModelCallBack {
            //注册
            void onZhuCeSuccess(ZhuCeBean zhuCeBean);
            void onZhuCeFailure(Throwable throwable);
        }
    }
}
