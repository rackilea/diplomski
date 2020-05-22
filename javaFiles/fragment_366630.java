System.out.println("DeviceGroups.choosenDevice " + DeviceGroups.choosenDevice);
String FILE_HEADER = "Testing Date;Seconds;" + printDeviceNames(DeviceGroups.choosenDevice);
System.out.println("FILE_HEADER " + FILE_HEADER);

  bufferedWriter.write(FILE_HEADER);

 private static String printDeviceNames(List<String> choosenDevice) {

    StringBuilder stringBuilder = new StringBuilder();

    for (String deviceName : choosenDevice) {
      stringBuilder.append(deviceName);
      stringBuilder.append(";");
    }

    return stringBuilder.toString();
  }