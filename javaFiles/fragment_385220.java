String s  = "GKJHGKJHGJ0123456789A<<BCDEFGH<IJKLMNO<<<<<<<PJHGKJHGKJ";
Pattern p = Pattern.compile("[A-Z0-9]{11}<<[A-Z0-9]{7}<[A-Z0-9]{7}<{7}[A-Z0-9]");
Matcher m = p.matcher(s);
while (m.find()) {
  System.out.println(m.group());
}