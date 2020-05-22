String legacyPingResult = str.toString();
String[] data = new String[3];
int splitPoint2 = legacyPingResult.lastIndexOf('§');
int splitPoint1 = legacyPingResult.lastIndexOf('§', splitPoint2 - 1);

data[0] = legacyPingResult.substring(0, splitPoint1);
data[1] = legacyPingResult.substring(splitPoint1 + 1, splitPoint2);
data[2] = legacyPingResult.substring(splitPoint2 + 1);