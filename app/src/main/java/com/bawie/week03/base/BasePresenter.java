package com.bawie.week03.base;

/*
 *@auther:杜其林
 *@Date: 2020/1/11
 *@Time:10:30
 *@Description:${DESCRIPTION}
 * */
public abstract class BasePresenter<V> {
    protected V view;

    public BasePresenter() {
        initModel();
    }

    protected abstract void initModel();

    public void attach(V view) {
        this.view = view;
    }

    public void detach(){
        view = null;
    }


}
