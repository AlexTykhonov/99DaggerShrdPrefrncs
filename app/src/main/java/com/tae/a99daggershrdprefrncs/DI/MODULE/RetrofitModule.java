package com.tae.a99daggershrdprefrncs.DI.MODULE;

import com.tae.a99daggershrdprefrncs.DI.Scope.ActivityScope;
import com.tae.a99daggershrdprefrncs.Network.BbcInter;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import static com.tae.a99daggershrdprefrncs.Network.BbcInter.BASE_URL;


@Module
public class RetrofitModule {

    @Provides
    @ActivityScope
  public BbcInter getApiInterface(Retrofit retrofit) {
      return retrofit.create(BbcInter.class);
    }

    @Provides
    @ActivityScope
    Retrofit getRetrofit (OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    @ActivityScope
    OkHttpClient getOkHttpClient (HttpLoggingInterceptor httpLoggingInterceptor) {
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        return client;
    }

    @Provides
    @ActivityScope
    HttpLoggingInterceptor getHttpLoginInterceptor () {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }

}
