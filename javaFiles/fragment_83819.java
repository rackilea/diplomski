String procTime="125-23:02:01";
String pattern = "([0-9]+)-([0-9]+):([0-9]+):([0-9]+).*";
Pattern r = Pattern.compile(pattern);
Matcher mt = r.matcher(procTime);
if (mt.find()) {
   String a = mt.group(0); // should work now
   String d = mt.group(1);
}