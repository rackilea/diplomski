BufferedReader reader = 
                new BufferedReader(new InputStreamReader(process.getInputStream()));
StringBuilder builder = new StringBuilder();
String line = null;
while ( (line = reader.readLine()) != null) {
   builder.append(line);
   builder.append(System.getProperty("line.separator"));
}
String result = builder.toString();