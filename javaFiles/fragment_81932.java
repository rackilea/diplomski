String str = "$d4kjvdf,78953626,10.0,103007,0,132103.8945F,";
Pattern regex = Pattern.compile(
  "([^,]+),([^,]+),([^,]+),([^,]+),([^,]+),([^,]+),?");
Matcher m = regex.matcher(str);

if(m.matches()) {
  for (int i = 1; i <= m.groupCount(); i++) {
    System.out.println(m.group(i));
  }
}