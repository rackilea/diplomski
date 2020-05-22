Pattern p=Pattern.compile("^(?!.*paragraph).*$",Pattern.MULTILINE);
 Matcher m=p.matcher(input);
 while(m.find())
 {
     Matcher mm=Pattern.compile("\\([a-zA-Z]\\)").matcher(m.group(0));
     while(mm.find())
     {
         System.out.println(mm.group(0));
     }
 }