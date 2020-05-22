String st = "((1,2),(2,3),(3,4),(4,5),(2,3))";

Pattern p = Pattern.compile("\\((\\d+),(\\d+)\\)");
Matcher m = p.matcher(st);
List<String> matches = new ArrayList<>();
while (m.find()) {
    matches.add(m.group(1) + "," + m.group(2));
}
System.out.println(matches);