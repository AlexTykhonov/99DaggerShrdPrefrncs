package com.tae.a99daggershrdprefrncs.DI.MODULE;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.tae.a99daggershrdprefrncs.DI.Scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

@Module
public class SharedPrefModule {

    Context context;

    public SharedPrefModule(Context context) {
        this.context = context;
    }

    @Provides
    @ActivityScope
    public Context providesContext(){
        return this.context;

    }

    @Provides
    @ActivityScope
    public SharedPreferences providesSharedPreferences(Context context)
    { return PreferenceManager.getDefaultSharedPreferences(context);

}
}
