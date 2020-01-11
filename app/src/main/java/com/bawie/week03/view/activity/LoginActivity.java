package com.bawie.week03.view.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bawie.week03.R;
import com.bawie.week03.base.BaseActivity;
import com.bawie.week03.contract.ILoginContract;
import com.bawie.week03.model.bean.LoginBean;
import com.bawie.week03.model.bean.ZhuCeBean;
import com.bawie.week03.presenter.LoginPresenter;

import butterknife.BindView;
import butterknife.OnClick;


public class LoginActivity extends BaseActivity<LoginPresenter> implements ILoginContract.IView{

    @BindView(R.id.ed_phone)
    EditText edPhone;
    @BindView(R.id.ed_pwd)
    EditText edPwd;
    @BindView(R.id.bt_zhuce)
    Button btZhuce;
    @BindView(R.id.bt_login)
    Button btLogin;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected LoginPresenter providePresenter() {
        return new LoginPresenter();
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_login;
    }

    @OnClick({R.id.bt_zhuce, R.id.bt_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_zhuce:
                String phone1 = edPhone.getText().toString();
                if (TextUtils.isEmpty(phone1)) {
                    Toast.makeText(this, "手机号不能为空", Toast.LENGTH_SHORT).show();
                }
                String pwd1 = edPwd.getText().toString();
                if (TextUtils.isEmpty(pwd1)){
                    Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
                }
                mPresenter.getZhuCeData(phone1,pwd1);
                break;
            case R.id.bt_login:
                String phone = edPhone.getText().toString();
                if (TextUtils.isEmpty(phone)) {
                    Toast.makeText(this, "手机号不能为空", Toast.LENGTH_SHORT).show();
                }
                String pwd = edPwd.getText().toString();
                if (TextUtils.isEmpty(pwd)){
                    Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
                }
                mPresenter.getLoginData(phone,pwd);
                break;
        }
    }

    @Override
    public void onLoginSuccess(LoginBean loginBean) {
        Intent intent=new Intent(LoginActivity.this, MainActivity.class);
        intent.putExtra("key",loginBean.getResult().getHeadPic());
        startActivity(intent);
    }

    @Override
    public void onLoginFailure(Throwable throwable) {
        Toast.makeText(this, "登录失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onZhuCeSuccess(ZhuCeBean zhuCeBean) {
        Toast.makeText(this, zhuCeBean.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onZhuCeFailure(Throwable throwable) {
        Toast.makeText(this, "注册失败", Toast.LENGTH_SHORT).show();
    }
}
