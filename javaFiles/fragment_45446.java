String s  = "4-3";
Pattern p = Pattern.compile("(?<before>\\D|^)(?<group>-?\\d+(\\.\\d+)?)(?<after>\\D|$)");
Matcher m = p.matcher(s);
while (m.find()) {
  System.out.println(m.group("before"));  //=> ""
  System.out.println(m.group("group"));   //=> "4"
  System.out.println(m.group("after"));   //=> "-"
}