String charset = "ISO-8859-1"; // or what corresponds
  BufferedReader in = new BufferedReader( 
      new InputStreamReader (new FileInputStream(file), charset));
  String line;
  while( (line = in.readLine()) != null) { 
    ....
  }