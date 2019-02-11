package com.tae.a99daggershrdprefrncs;

import android.app.Activity;
import android.app.Application;

import com.tae.a99daggershrdprefrncs.DI.Components.ApplicationComponent;
import com.tae.a99daggershrdprefrncs.DI.Components.DaggerApplicationComponent;
import com.tae.a99daggershrdprefrncs.DI.MODULE.ContextModule;


public class MyApplication extends Application {
    ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
    // используется для сборки модулей присутствующих в компоненте
        applicationComponent = DaggerApplicationComponent
                .builder()
                .contextModule(new ContextModule(this))
                .build();
        applicationComponent.injectApplication(this);
    }

    //
    public static MyApplication get(Activity activity){
        return (MyApplication) activity.getApplication();
    }
    // используется для внедрения ApplicationComponent into Activity

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
