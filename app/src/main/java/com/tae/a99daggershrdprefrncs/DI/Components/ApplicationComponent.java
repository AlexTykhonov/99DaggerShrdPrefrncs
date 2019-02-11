package com.tae.a99daggershrdprefrncs.DI.Components;

import android.content.Context;

import com.tae.a99daggershrdprefrncs.DI.Scope.ApplicationContext;
import com.tae.a99daggershrdprefrncs.DI.Scope.ApplicationScope;
import com.tae.a99daggershrdprefrncs.DI.MODULE.ContextModule;
import com.tae.a99daggershrdprefrncs.MyApplication;

import dagger.Component;

@ApplicationScope
@Component (modules = {ContextModule.class})
public interface ApplicationComponent {

    @ApplicationContext
    public Context getContext();

    public void injectApplication(MyApplication myApplication);

}
