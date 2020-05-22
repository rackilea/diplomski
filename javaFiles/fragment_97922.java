InputStream  inputStream = Main.class.getResourceAsStream("myFile.json");

InputStreamReader isReader = new InputStreamReader(inputStream);

BufferedReader reader = new BufferedReader(isReader);
  StringBuffer sb = new StringBuffer();
  String str;
  while((str = reader.readLine())!= null){
     sb.append(str);
  }