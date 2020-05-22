String test = "this is a test 123. 1";
//                           | group 1: any 1+ char sequence reluctantly quantified, 
//                           |     | followed by a dot, non-capturing here
//                           |     |
//                           |     |     | any character reluctantly quantified
//                           |     |     | (here, your whitespace)
//                           |     |     |  | group 2: 1 or 2
Pattern p = Pattern.compile("(.+?)(?=\\.).*?([01])");
Matcher m = p.matcher(test);
if (m.find()) {
    System.out.printf("Group 1: %s%nGroup 2: %s%n", m.group(1), m.group(2));
}