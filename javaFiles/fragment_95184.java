ProcessBuilder pb = new ProcessBuilder("netsh", "wlan", "connect",
    "name=\"Profile Name\"", "ssid=XXXXX");
pb.redirectErrorStream(true);
Process process = pb.start();
BufferedReader reader = new BufferedReader(
    new InputStreamReader(process.getInputStream()));
String line = null;
while ((line = reader.readLine()) != null) {
    System.out.println(line);
}