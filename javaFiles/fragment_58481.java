/**
 * Queries a device for its build info.
 * @param device the device to query.
 */
private void queryNewDeviceForInfo(Device device) {
    // TODO: do this in a separate thread.
    try {
        // first get the list of properties.
        device.executeShellCommand(GetPropReceiver.GETPROP_COMMAND,
                new GetPropReceiver(device));

        queryNewDeviceForMountingPoint(device, IDevice.MNT_EXTERNAL_STORAGE);
        queryNewDeviceForMountingPoint(device, IDevice.MNT_DATA);
        queryNewDeviceForMountingPoint(device, IDevice.MNT_ROOT);

        // now get the emulator Virtual Device name (if applicable).
        if (device.isEmulator()) {
            EmulatorConsole console = EmulatorConsole.getConsole(device);
            if (console != null) {
                device.setAvdName(console.getAvdName());
            }
        }
    } catch (TimeoutException e) {
        Log.w("DeviceMonitor", String.format("Connection timeout getting info for device %s",
                device.getSerialNumber()));

    } catch (AdbCommandRejectedException e) {
        // This should never happen as we only do this once the device is online.
        Log.w("DeviceMonitor", String.format(
                "Adb rejected command to get  device %1$s info: %2$s",
                device.getSerialNumber(), e.getMessage()));

    } catch (ShellCommandUnresponsiveException e) {
        Log.w("DeviceMonitor", String.format(
                "Adb shell command took too long returning info for device %s",
                device.getSerialNumber()));

    } catch (IOException e) {
        Log.w("DeviceMonitor", String.format(
                "IO Error getting info for device %s",
                device.getSerialNumber()));
    }
}