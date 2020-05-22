NTPUDPClient client = new NTPUDPClient();
client.setDefaultTimeout(5000);
client.open();
InetAddress hostAddr = InetAddress.getByName(confFile.getIpAddresse());
TimeInfo info = client.getTime(hostAddr, 8110);
info.computeDetails(); // compute offset/delay if not already done
Long offsetValue = info.getOffset();
Long delayValue = info.getDelay();
String delay = (delayValue == null) ? "0" : delayValue.toString();
String offset = (offsetValue == null) ? "0" : offsetValue.toString();
System.out.println(" Roundtrip delay(ms)=" + delay + ", clock offset(ms)=" + offset); 
// offset in ms
client.close();
StaticVariables.timeDifference = Long.parseLong(offset);