String line;
Process p = Runtime.getRuntime().exec("wmic PATH Win32_videocontroller GET description");
BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
while ((line = input.readLine()) != null) {
   System.out.println(line);
}
input.close();