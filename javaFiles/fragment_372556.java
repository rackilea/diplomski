String propertyValue = "component:keyboard;determinantType:key;determinant:test;waste";

// tokenize the input string with the separator
StringTokenizer tokenizer = new StringTokenizer(test, ";");

// get the tokens and replace the unwanted part
String component = tokenizer.nextToken().replaceAll("component:", "");
String determinantType = tokenizer.nextToken().replaceAll("determinantType:","");
String determinant = tokenizer.nextToken().replaceAll("determinant:", "");
String endElement = tokenizer.nextToken();

System.out.println(">>1"+component+" 2>>"+determinantType+" 3>>"+determinant+" 4>>"+endElement);