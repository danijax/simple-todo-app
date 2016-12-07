package com.danieljames.simpletodo;


import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ServiceGenerator {

    public static final String API_BASE_URL = BuildConfig.TMDB_BASE_URL;
    //private static RestAdapter.Builder builder =
    final static OkHttpClient.Builder okHttp = new OkHttpClient.Builder();

    private static Retrofit builder = new Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttp.build())
            .build();

    public static  <S> S createService(Class<S> service){
        return builder.create(service);
    }
}