String rs = (String)pluginOutputs.get("ExternalLibrarySystem");
StringBuilder sb = new StringBuilder();
Scanner sc = new Scanner(rs);
  int cnt = 0;
  while (sc.hasNextLine()) {
   if(cnt>4){
      sb.append(sc.nextLine()+System.getProperty("line.separator"));
   }
   cnt++;
  }
String temp = sb.toString();