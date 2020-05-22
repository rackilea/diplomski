Pattern pattern = Pattern.compile("^a{3}");
Matcher m = pattern.matcher("xxaaa");
m.region(2, m.regionEnd()); // <---- region start is now 2

System.out.println(m.find());
System.out.println(m.lookingAt());