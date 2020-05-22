//ExitModule.java
package com.security_notifier;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReactContext;
import android.app.Activity;

public class ExitModule extends ReactContextBaseJavaModule {

    private ReactContext mReactContext;
    public ExitModule(ReactApplicationContext reactContext) {
        super(reactContext); //required by React Native
        mReactContext = reactContext;
    }


    @Override
    //getName is required to define the name of the module represented in JavaScript
    public String getName() {
        return "Exit";
    }

    @ReactMethod
    public void finishApp() {
        Activity activity = mReactContext.getCurrentActivity();
        activity.finish();
    }
}