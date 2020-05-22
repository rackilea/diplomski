String s = "P67XDF9K7 12/12/12 confirmed you have  received Ksh4,033.00 from 254723981091 on 7/9/14 at 6:45PM your new M-PE";
Pattern p = Pattern.compile("[0-9]{1,2}\\Q/\\E[0-9]{1,2}\\Q/\\E[0-9]{2}");
Matcher m = p.matcher(s);
while (m.find()) {
  System.out.println(m.group(0));
}