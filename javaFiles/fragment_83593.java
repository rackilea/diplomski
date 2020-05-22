Pattern pattern=Pattern.compile("Your Regex");  
Matcher matcher=pattern.matcher("Source String");

 while (matcher.find())                    // true if matches
    {
     System.out.println(matcher.group());  //prints string token  
    }