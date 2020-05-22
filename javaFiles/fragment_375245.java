String str = "word1{word2}[word3](word4)\"word5\"'word6'";
Matcher m = Pattern.compile("(([{\\[(\"']\\w+[}\\])\"'])|(\\w+))").matcher(str);
List<String> matches = new ArrayList<>();

while (m.find())
    matches.add(m.group());

String[] matchesArray = matches.toArray(new String[0]);
System.out.println(Arrays.toString(matchesArray));