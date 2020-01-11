package com.bawie.week03.model;

import com.bawie.week03.contract.ILoginContract;
import com.bawie.week03.model.bean.LoginBean;
import com.bawie.week03.model.bean.ZhuCeBean;
import com.bawie.week03.util.NetUtil;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/*
 *@auther:杜其林
 *@Date: 2020/1/11
 *@Time:13:47
 *@Description:${DESCRIPTION}
 * */
public class LoginModel implements ILoginContract.IModel{
    @Override
    public void getLoginData(String phone, String pwd, ILoginModelCallBack iLoginModelCallBack) {
        NetUtil.getInstance().getApi().longinBean(phone,pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        iLoginModelCallBack.onLoginSuccess(loginBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iLoginModelCallBack.onLoginFailure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getZhuCeData(String phone, String pwd, IZhuCeModelCallBack iZhuCeModelCallBack) {
        NetUtil.getInstance().getApi().zhuCeBean(phone,pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ZhuCeBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ZhuCeBean zhuCeBean) {
                        iZhuCeModelCallBack.onZhuCeSuccess(zhuCeBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iZhuCeModelCallBack.onZhuCeFailure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
