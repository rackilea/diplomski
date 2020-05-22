ArrayList <String> strVector = new ArrayList<String>();
  strVector.add("hello");
  strVector.add("ohhhhh");
  strVector.add("whatsuppp");
  strVector.add("aaa");
  strVector.add("aaahhhahj");
  strVector.add("abcdef");
  strVector.add("abceeedef");

  Pattern pattern = Pattern.compile("^.*(.)\\1\\1.*$");
  Matcher matcher;        

  for(String elem:strVector)
  {
    System.out.println(elem);
    matcher = pattern.matcher(elem);
    if (matcher.find())System.out.println("Found you!");
    else System.out.println("Not Found!");
  }