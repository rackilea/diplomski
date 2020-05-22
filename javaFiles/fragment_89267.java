Pattern p = Pattern.compile("aa");
Matcher m = p.matcher("aaaa");
int count = 0;
int start = 0;
while(m.find(start)) {
  count++;
  start = m.start() + 1;
}
System.out.println(count);