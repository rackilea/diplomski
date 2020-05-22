public void readProteins(BufferedReader br, BufferedWriter bw) throws IOException
{     
  Pattern regexSplit = Pattern.compile(">");
  Pattern proteinPattern = Pattern.compile("(.*?)([A-Z]{5,})");
  Matcher m;
  Scanner s = new Scanner(br);
  s.useDelimiter(regexSplit);         
  while (s.hasNext())
  {
      StringBuffer sb = new StringBuffer();
      String protein = s.next();
      m = proteinPattern.matcher(protein);            
      if (m.find())
          sb.append(m.group(2)).reverse().append(">r-").insert(0, m.group(1));
      else
          sb.append(protein);
      );          
  }
  bw.flush();
  bw.close();
}