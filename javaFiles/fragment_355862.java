DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,
     "Selendroid");
    capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
    capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "4.3");
    capabilities.setCapability(MobileCapabilityType.APP_PACKAGE: "wizzo.mbc.net");
    capabilities.setCapability(MobileCapabilityType.APP_ACTIVITY: "wizzo.mbc.net.activities.SplashActivity");