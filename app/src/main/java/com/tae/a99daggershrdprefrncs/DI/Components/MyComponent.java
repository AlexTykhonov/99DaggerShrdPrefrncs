package com.tae.a99daggershrdprefrncs.DI.Components;

import android.content.Context;

import com.tae.a99daggershrdprefrncs.DI.Scope.ActivityContext;
import com.tae.a99daggershrdprefrncs.DI.Scope.ActivityScope;
import com.tae.a99daggershrdprefrncs.DI.MODULE.AdapterModule;
import com.tae.a99daggershrdprefrncs.DI.MODULE.RetrofitModule;
import com.tae.a99daggershrdprefrncs.DI.MODULE.SharedPrefModule;
import com.tae.a99daggershrdprefrncs.MainActivity;

import dagger.Component;

@ActivityScope
@Component (modules = {SharedPrefModule.class, RetrofitModule.class, AdapterModule.class})

public interface MyComponent {

    @ActivityContext
    Context getContext();

void inject(MainActivity mainActivity);
        }
