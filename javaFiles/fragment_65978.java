Pattern p = Pattern.compile(
             "(\\d{1,2}:\\d{1,2}:\\d{1,2})\\s*,\\s*(\\d{1,2}:\\d{1,2}:\\d{1,2})");

Matcher m = p.matcher( "12:00:00, 2:30:003:45:00,23:45:00" );

List<String> list1 = new ArrayList<>(); 
List<String> list2 = new ArrayList<>(); 

while (m.find()) {
    list1.add(m.group(1));
    list2.add(m.group(2));
}

System.out.printf("%s%n%s%n", list1, list2);