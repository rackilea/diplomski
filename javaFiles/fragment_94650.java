Matcher m = Pattern.compile(yourRegex).matcher(yourString)
  while (m.find()) 
  {
      System.out.println(m.group(1));
      System.out.println(m.group(2));
      String state = m.group(6);
      ...
  }