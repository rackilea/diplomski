public void addDriverDevice(DeviceDriver deviceDriver)  {
    deviceDriver.setDriver(deviceDriver);
    driverDevices.add(deviceDriver);
}

public void removeDriverDevice(DeviceDriver deviceDriver)  {
    deviceDriver.setDriver(null);
    driverDevices.remove(deviceDriver);
}