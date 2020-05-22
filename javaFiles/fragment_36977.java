//our data
String test = "Hello @\"Thomas Anderson\" how are you? Today is 06/13/2013 com month day year !! \"example of date\"";
String x = "com";
String y = "word";

//splitting string into parts before and after 'x' word
int brakePoint = test.indexOf(x) + x.length();
String prefix=test.substring(0,brakePoint);
String suffix=test.substring(brakePoint);

//in part after `x` replacing quotes OR set of non-white-space characters with 'y'
suffix = suffix.replaceAll("\"[^\"]+\"|\\S+", y);

//result
System.out.println(prefix+suffix);