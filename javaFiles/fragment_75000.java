Plain regex:
^.*? href=\\'([^']+)\'[^>]*>([^<]*)<

or, in Java:

Pattern p = Pattern.compile("^.*? href=\\\\'([^']+)\\'[^>]*>([^<]*)<", 
                            Pattern.MULTILINE);
Matcher m = p.matcher(hideousString);
m.find();
// Now m.group(1) is the URL and m.group(2) is the text