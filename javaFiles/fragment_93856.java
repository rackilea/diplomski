URL url = new URL("ftp://mirror.csclub.uwaterloo.ca/index.html");
   URLConnection urlConnection = url.openConnection();
   InputStream in = new BufferedInputStream(urlConnection.getInputStream());
   try {
     readStream(in);
    finally {
     in.close();
   }
 }