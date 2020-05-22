public static List<Device> DEVICES = new ArrayList<>();

class Device {
  Date date;
  long time;
  Integer opened;
  String deviceId;
  String deviceRssi

  Device(Date date, Integer opened, String deviceId, String deviceRssi) {
    this.date = date;
    this.time = date.getTime();
    this.opened = opened;
    this.deviceId = deviceId;
    this.deviceRssi = deviceRssi;
  }
}

Device first = new Device(
  new Date(),
  0,
  "",
  "");

DEVICES.add(first);
System.out.println(DEVICES.get(0).deviceId);
...
for (Device device : DEVICES) {
  if (device.deviceId.equals("33)) {
    // ...
  }
}