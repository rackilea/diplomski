String s = "arg1 : val1 arg2 : val2 arg3 : va:l3";

if (s.contains("arg")) {

  Pattern pattern = Pattern.compile("arg1 :(.*?)arg2");
  Matcher matcher = pattern.matcher(s);
  while (matcher.find()) {
       System.out.println(matcher.group(1));                                
       String value = matcher.group(1);
       System.out.println(value);   
  }
}