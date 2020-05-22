String data = "1a2b-3c";
int sum=0;
Pattern p = Pattern.compile("-?\\d+");
Matcher m = p.matcher(data);
while (m.find()) {
  sum+=Integer.parseInt(m.group());
}