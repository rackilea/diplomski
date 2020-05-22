HttpClient httpclient = new DefaultHttpClient(); // Create HTTP Client
  HttpGet httpget = new HttpGet("http://yoururl.com"); // Set the action you want to do
 HttpResponse response = httpclient.execute(httpget); // Executeit
 HttpEntity entity = response.getEntity(); 
 InputStream is = entity.getContent(); // Create an InputStream with the response
  BufferedReader reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
    StringBuilder sb = new StringBuilder();
   String line = null;
   while ((line = reader.readLine()) != null) // Read line by line
        sb.append(line + "\n");
    String resString = sb.toString(); // Result is here
     is.close(); // Close the stream
    File file = new File(Environment.getExternalStorageDirectory().toString()+"/Path/to/save/file/index.html");
        file.createNewFile();
        FileOutputStream f1 = new FileOutputStream(file, false);
        PrintStream p = new PrintStream(f1);
        p.print(resString);
        p.close();
        f1.close();

    }catch(IOException e){}