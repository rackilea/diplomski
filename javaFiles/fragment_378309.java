// input
String s = "5 + 4 + 3 - 2 - 10 + 15";
ArrayList<Integer> numbers = new ArrayList<Integer>();

// remove whitespace
s = s.replaceAll("\\s+", "");

// parse string
Pattern pattern = Pattern.compile("[-]?\\d+");
Matcher matcher = pattern.matcher(s);

// add numbers to array
while (matcher.find()) {
  numbers.add(Integer.parseInt(matcher.group()));
}

// numbers
// {5, 4, 3, -2, -10, 15}