Matcher m = p.matcher("a number ([0-9]*), a name (\w*)");

 if (m.find()) {
    System.out.println(m.group(0)); // number
    System.out.println(m.group(1)); // name
 }