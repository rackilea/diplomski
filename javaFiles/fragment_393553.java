Pattern pattern = Pattern.compile("((?:-)?([0-9]+(?:\\.)?[0-9]+))|([A-Z]([A-Z/]|\\s)+[A-Z])");
Matcher matcher = pattern.matcher("9790020760001613 JOHN MATHEWS S/O          -66822.60        65000.00        69000.00        -1822.60  KARL MAX");
List<String> matches = new ArrayList<String>();
while (matcher.find()) {
    matches.add(matcher.group());
}
System.out.println(Arrays.toString(matches.toArray()));