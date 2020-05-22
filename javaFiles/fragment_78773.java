String str = "move 55 up;2 right;100 down;8 left";
String regex = "(\\d+ (?:up|down|left|right))";
List<String> matches = new ArrayList<String>();
Matcher m = Pattern.compile(regex).matcher(str);

while (m.find()) {
    matches.add(m.group());
}

System.out.println(matches);
// Output: [55 up, 2 right, 100 down, 8 left]