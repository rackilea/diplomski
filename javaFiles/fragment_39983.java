FileInputStream fis = context.openFileInput("myfile.txt", Context.MODE_PRIVATE);
 InputStreamReader isr = new InputStreamReader(fis);
 BufferedReader bufferedReader = new BufferedReader(isr);
 StringBuilder sb = new StringBuilder();
 String line;
 while ((line = bufferedReader.readLine()) != null) {
     sb.append(line);
 }

 String json = sb.toString();
 Gson gson = new Gson();
 Vector v = gson.fromJson(json, Vector.class);