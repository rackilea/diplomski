ProcessBuilder builder = new ProcessBuilder("command goes here");
builder.redirectErrorStream(true);
Process process = builder.start();
InputStream is = process.getInputStream();
BufferedReader reader = new BufferedReader(new InputStreamReader(is));

String line = null;
while ((line = reader.readLine()) != null) {
   System.out.println(line);
}