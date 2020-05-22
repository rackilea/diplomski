public void clearDriverDevices()  {
    for (DeviceDriver deviceDriver : deviceDrivers) {
        deviceDriver.setDriver(null);
        driverDevices.remove(deviceDriver);
    }
}