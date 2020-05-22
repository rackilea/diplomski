public interface IPDevice<DeviceName extends Enum> {
    //factory method
    Device createNewIPDevice(DeviceName deviceName);
}

public interface USBDevice<DeviceName extends Enum> {
    //factory method
    Device createNewUSBDevice(DeviceName deviceName);
}

public class MicrosoftDevice implements IPDevice<DeviceNames.Microsoft> {
    @Override
    public Device createNewIPDevice(DeviceNames.Microsoft deviceName) {
        return super(deviceName.toString());
    }
}

public class AppleDevice implements IPDevice<DeviceNames.Apple>, USBDevice<DeviceNames.Apple> {
    @Override
    public Device createNewIPDevice(DeviceNames.Apple deviceName) {
        return super(deviceName.toString());
    }

    @Override
    public Device createNewUSBDevice(DeviceNames.Apple deviceName) {
        return super(deviceName.toString();
    }
}