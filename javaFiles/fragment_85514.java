Pattern p = Pattern.compile("\\s+" +    // sequence of whitespace
                           "|\\w+" +    // sequence of word characters
                           "|'[^']*'" + // Characters surrounded by ' '
                           "|[:><]=" +  // :=   >=   <=
                           "|<>" +      // <>
                           "|\\.\\." +  // ..
                           "|.");       // Any single other character
String input = "print('*');  x := x - 100";
for (Matcher m = p.matcher(input); m.find(); )
    System.out.println(m.group());