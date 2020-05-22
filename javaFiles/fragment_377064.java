addDevice(Device device) {
    if (device.user() != null) {
        device.user().removeDevice(device)
    }
    device.setUser(this)
    devices.add(device);
}