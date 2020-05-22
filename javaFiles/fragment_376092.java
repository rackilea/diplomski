String a = "I am ready at time -S 2019-06-16:00:00:00 and be there";
String pattern = "\\d{4}-\\d{2}-\\d{2}:\\d{2}:\\d{2}:\\d{2}";
Pattern r = Pattern.compile(pattern);
Matcher m = r.matcher(a);
while (m.find()) {
     System.out.println("found a timestamp: " + m.group(0));
}