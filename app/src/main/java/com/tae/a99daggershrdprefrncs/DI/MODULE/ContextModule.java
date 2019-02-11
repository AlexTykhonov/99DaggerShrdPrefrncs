package com.tae.a99daggershrdprefrncs.DI.MODULE;

import android.content.Context;

import com.tae.a99daggershrdprefrncs.DI.Scope.ApplicationScope;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {
    Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @Provides
    @ApplicationScope
    public Context getContext() {
        return context;
    }
}
