String s  = "...... TESTYY912345 ......";
Pattern p = Pattern.compile("TEST\\p{ASCII}{2}(9\\d+)");
Matcher m = p.matcher(s);
if (m.find()) {
  System.out.println(m.group(1)); // 912345
}