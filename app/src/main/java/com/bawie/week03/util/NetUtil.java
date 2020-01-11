package com.bawie.week03.util;

import com.bawie.week03.Api;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/*
 *@auther:杜其林
 *@Date: 2020/1/11
 *@Time:10:48
 *@Description:${DESCRIPTION}
 * */
public class NetUtil {
    private final Api api;

    private NetUtil() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(5, TimeUnit.SECONDS)
                .connectTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(5, TimeUnit.SECONDS)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("http://172.17.8.100/")
                .client(okHttpClient)
                .build();
        api = retrofit.create(Api.class);
    }

    public static NetUtil getInstance() {
        return SinginHodler.netUtil;
    }

    private static final class SinginHodler{
        private static final NetUtil netUtil = new NetUtil();
    }

    public Api getApi() {
        return api;
    }
}
