private AppiumDriver<MobileElement> setCaps(Devices d, String udid) throws MalformedURLException{
    AppiumDriver<MobileElement> driver = null;
    DesiredCapabilities cap = new DesiredCapabilities();

    String deviceName = "device"+ ++deviceNum;
    cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
    if(d == Devices.ANDROID) {
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
    }
    if(d == Devices.IOS) {
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "IOS");
    }
    cap.setCapability(MobileCapabilityType.UDID, udid.trim());
    cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "4000");
    cap.setCapability("noReset", false);