String value = "col = at, ud = sam, col = me, od = tt, col = fg";

Pattern pattern = Pattern.compile("col\\s+=\\s+\\w++");

List<String> allMatches = new ArrayList<String>();
Matcher m = pattern.matcher(value);
while (m.find()) {
   allMatches.add(m.group());
}
allMatches.forEach(System.out::print);