URL url = new URL("http://www.google.com");
 InputStream is = (InputStream) url.getContent();
 BufferedReader br = new BufferedReader(new InputStreamReader(is));
 String line = null;
 StringBuffer sb = new StringBuffer();
 while((line = br.readLine()) != null){
   sb.append(line);
 }
 String htmlContent = sb.toString();