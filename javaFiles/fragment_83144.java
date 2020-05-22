is = test.getInputStream();
br = new BufferedReader(new InputStreamReader(is));
String line5;
StringBuilder sb5 = new StringBuilder();
while ((line5 = br.readLine()) != null) {
    sb5.append(line5);
    sb5.append("\n");
}