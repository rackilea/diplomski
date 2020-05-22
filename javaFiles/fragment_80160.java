abstract class TempDeviceMixIn {
    @JsonProperty("devices")
    private List<String> tempDevice;
}

abstract class DeviceMixIn {
    @JsonProperty("devices")
    private List<Device> devices;
}