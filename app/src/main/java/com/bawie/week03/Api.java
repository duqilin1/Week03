package com.bawie.week03;

import com.bawie.week03.model.bean.CartBean;
import com.bawie.week03.model.bean.LoginBean;
import com.bawie.week03.model.bean.ZhuCeBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

/*
 *@auther:杜其林
 *@Date: 2020/1/11
 *@Time:10:34
 *@Description:${DESCRIPTION}
 * */
public interface Api {
    //购物车
    @GET("small/order/verify/v1/findShoppingCart")
    Observable<CartBean> cartBean(@Header("userid") String userid, @Header("sessionid") String sessionid);

    //登录
    @FormUrlEncoded
    @POST("small/user/v1/login")
    Observable<LoginBean> longinBean(@Field("phone") String phone, @Field("pwd") String pwd);
    //注册
    @FormUrlEncoded
    @POST("small/user/v1/register")
    Observable<ZhuCeBean> zhuCeBean(@Field("phone") String phone, @Field("pwd") String pwd);
}
