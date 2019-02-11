package com.tae.a99daggershrdprefrncs;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.tae.a99daggershrdprefrncs.DI.Components.DaggerMyComponent;
import com.tae.a99daggershrdprefrncs.DI.Components.MyComponent;
import com.tae.a99daggershrdprefrncs.DI.MODULE.AdapterModule;
import com.tae.a99daggershrdprefrncs.DI.MODULE.RetrofitModule;
import com.tae.a99daggershrdprefrncs.DI.MODULE.SharedPrefModule;
import com.tae.a99daggershrdprefrncs.Network.BbcInter;
import com.tae.a99daggershrdprefrncs.Network.PojoNbu;
import com.tae.a99daggershrdprefrncs.Network.PostsAdapter;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    MyComponent myComponent;

    Retrofit retrofit;
    RecyclerView recyclerView;

    @Inject
    PostsAdapter recyclerViewAdapter;


    @Inject
    SharedPreferences sharedPreferences;


    @Inject
    BbcInter bbcInter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        myComponent = DaggerMyComponent
                .builder()
                .sharedPrefModule(new SharedPrefModule(this))
                .retrofitModule(new RetrofitModule())
                .adapterModule (new AdapterModule(this))
                .build();
        myComponent.inject(this);


    recyclerView = findViewById(R.id.recycle_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerViewAdapter);


        bbcInter.getRecipepuppy("lemon","pie",3)
                .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(this::handleResults, this::handleError);

}
    public void handleResults(PojoNbu bbcNews)
    {
        if (bbcNews != null ) {
            recyclerViewAdapter.setData(bbcNews);

        } else {
            Toast.makeText(this, "NO RESULTS FOUND",
                    Toast.LENGTH_LONG).show();
        }
    }

    public void handleError(Throwable t){
        System.out.println(t+"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }


}
