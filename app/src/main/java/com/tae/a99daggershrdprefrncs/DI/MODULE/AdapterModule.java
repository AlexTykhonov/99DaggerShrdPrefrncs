package com.tae.a99daggershrdprefrncs.DI.MODULE;

import android.content.Context;

import com.tae.a99daggershrdprefrncs.DI.Scope.ActivityScope;
import com.tae.a99daggershrdprefrncs.Network.PostsAdapter;

import dagger.Module;
import dagger.Provides;

@Module
public class AdapterModule {

    Context context;

    public AdapterModule(Context context) {
    this.context = context;
    }

    @Provides
    @ActivityScope
    PostsAdapter getAdapter () {
        return new PostsAdapter(context);
    }
}
