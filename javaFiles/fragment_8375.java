Pattern p = Pattern.compile("^\\{(.+?)\\}\\.(.*)$");
//                                \ /        \/
//                                 1          2

Matcher match = p.matcher("{Item1}.Item2");
while(match.find()) {
  System.out.println("1 = " + match.group(1));
  System.out.println("2 = " + match.group(2));
}