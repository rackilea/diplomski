Process p = Runtime.getRuntime().exec("A command");
BufferedReader in = new BufferedReader(new InputStreamReader(p.getErrorStream()));
StringBuilder builder = new StringBuilder();
String line = null;
 while ((line = in.readLine()) != null) {
     builder.append(line + "\n");
 } 
String result = builder.toString();