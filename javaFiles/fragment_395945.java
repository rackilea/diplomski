@Override
protected IOSApplication createApplication() {

    final IOSApplicationConfiguration config = new IOSApplicationConfiguration();
    config.orientationLandscape = false;
    config.orientationPortrait = true;
    config.useAccelerometer = false;
    config.useCompass = false;

    iosApplication = new IOSApplication(new SplishGame(this), config);
    return iosApplication;
}