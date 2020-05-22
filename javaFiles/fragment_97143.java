String temp = "74 4F 4C 4F 49 65  brown fox jump over the fence";
List<String> arr = new ArrayList<String>();
Pattern p = Pattern.compile("(?i)(?:^|\\s+)([a-z]+)");
Matcher m = p.matcher(temp);
while (m.find())
    arr.add(m.group(1));

// convert to String[]
String[] word = arr.toArray(new String[0]);
System.out.println( Arrays.toString(word) );