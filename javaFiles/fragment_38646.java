package com.MyProject;

// ...

public class MainApplication extends Application implements ReactApplication {

  private final ReactNativeHost mReactNativeHost = new ReactNativeHost(this) {

    // ...

    // ADD THE LINES BELOW

    @Override
    protected String getJSMainModuleName() {
      return "src/index.android";
    }

    // ADD THE LINES ABOVE

  };

  // ...
}