package com.tae.a99daggershrdprefrncs.Network;

import com.tae.a99daggershrdprefrncs.Network.PojoNbu;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BbcInter
{
    
    String BASE_URL = "http://www.recipepuppy.com/";

    @GET("api/")
    Observable<PojoNbu> getRecipepuppy(@Query("i") String components, @Query("q") String dish, @Query("p") int page);
}