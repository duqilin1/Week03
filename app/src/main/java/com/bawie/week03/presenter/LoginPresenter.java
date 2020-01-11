package com.bawie.week03.presenter;

import com.bawie.week03.base.BasePresenter;
import com.bawie.week03.contract.ILoginContract;
import com.bawie.week03.model.LoginModel;
import com.bawie.week03.model.bean.LoginBean;
import com.bawie.week03.model.bean.ZhuCeBean;

/*
 *@auther:杜其林
 *@Date: 2020/1/11
 *@Time:13:57
 *@Description:${DESCRIPTION}
 * */
public class LoginPresenter extends BasePresenter<ILoginContract.IView> implements ILoginContract.IPresenter{

    private LoginModel loginModel;

    @Override
    protected void initModel() {
        loginModel = new LoginModel();
    }

    @Override
    public void getLoginData(String phone, String pwd) {
        loginModel.getLoginData(phone, pwd, new ILoginContract.IModel.ILoginModelCallBack() {
            @Override
            public void onLoginSuccess(LoginBean loginBean) {
                view.onLoginSuccess(loginBean);
            }

            @Override
            public void onLoginFailure(Throwable throwable) {
                view.onLoginFailure(throwable);
            }
        });
    }

    @Override
    public void getZhuCeData(String phone, String pwd) {
        loginModel.getZhuCeData(phone, pwd, new ILoginContract.IModel.IZhuCeModelCallBack() {
            @Override
            public void onZhuCeSuccess(ZhuCeBean zhuCeBean) {
                view.onZhuCeSuccess(zhuCeBean);
            }

            @Override
            public void onZhuCeFailure(Throwable throwable) {
                view.onZhuCeFailure(throwable);
            }
        });
    }
}
