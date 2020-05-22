FileInputStream fis = new FileInputStream(path);
BufferedReader br = new BufferedReader(new InputStreamReader(fis, "UTF-8"));
String line;
while ((line = br.readLine()) != null) {
   /* process line */
   /* report percentage */
}