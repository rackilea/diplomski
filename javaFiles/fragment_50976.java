String encoding = "UTF-8";
BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("/bigfile.txt"), encoding));
String line;
while ((line = br.readLine()) != null) {
   // process the line.
}
br.close();