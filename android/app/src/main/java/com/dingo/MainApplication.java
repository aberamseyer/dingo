package com.dingo;

import android.app.Application;

import com.crashlytics.android.Crashlytics;
import com.dingo.SplashScreen.SplashScreenReactPackage;
import com.dingo.ProxiedFetch.ProxiedFetchReactPackage;
import com.facebook.react.ReactApplication;
import io.fabric.sdk.android.Fabric;
import io.invertase.firebase.RNFirebasePackage;
import com.swmansion.gesturehandler.react.RNGestureHandlerPackage;
import com.swmansion.reanimated.ReanimatedPackage;
import com.ocetnik.timer.BackgroundTimerPackage;
import com.guichaguri.trackplayer.TrackPlayer;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;
import com.facebook.soloader.SoLoader;
import org.pgsqlite.SQLitePluginPackage;

import java.util.Arrays;
import java.util.List;

import io.invertase.firebase.fabric.crashlytics.RNFirebaseCrashlyticsPackage;

public class MainApplication extends Application implements ReactApplication {

  private final ReactNativeHost mReactNativeHost = new ReactNativeHost(this) {
    @Override
    public boolean getUseDeveloperSupport() {
      return BuildConfig.DEBUG;
    }

    @Override
    protected List<ReactPackage> getPackages() {
      return Arrays.<ReactPackage>asList(
          new MainReactPackage(),
            new RNFirebasePackage(),
            new RNGestureHandlerPackage(),
            new ReanimatedPackage(),
            new SplashScreenReactPackage(),
            new ProxiedFetchReactPackage(),
            new BackgroundTimerPackage(),
          new TrackPlayer(),
          new SQLitePluginPackage(),
          new RNFirebaseCrashlyticsPackage()

      );
    }

    @Override
    protected String getJSMainModuleName() {
      return "index";
    }
  };

  @Override
  public ReactNativeHost getReactNativeHost() {
    return mReactNativeHost;
  }

  @Override
  public void onCreate() {
    Fabric.with(this, new Crashlytics());
    super.onCreate();
    SoLoader.init(this, /* native exopackage */ false);
  }
}
