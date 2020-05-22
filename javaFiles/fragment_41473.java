String string = "aabbccdefatafaz";

char[] chars = string.toCharArray();
Set<Character> charSet = new LinkedHashSet<Character>();
for (char c : chars) {
    charSet.add(c);
}

StringBuilder sb = new StringBuilder();
for (Character character : charSet) {
    sb.append(character);
}
System.out.println(sb.toString());