Runtime r = Runtime.getRuntime();
Process p = r.exec("uname -a");
p.waitFor();
BufferedReader b = new BufferedReader(new InputStreamReader(p.getInputStream()));
String line = "";

while ((line = b.readLine()) != null) {
  System.out.println(line);
}

b.close();