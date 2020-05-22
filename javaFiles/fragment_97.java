Pattern replacePattern = Pattern.compile("\\w+#(\\d+)\\.\\w+");
Matcher m = replacePattern.matcher("c#1.text2"); // same way for d#2.text3
if (m.matches()) {
    String digit = m.group(1); // the digit you wanted to extract
    String retVal = "a#?.text1".replaceFirst("(?<=#)\\?", digit); // replace ? preceded by # with the digit using replaceFirst
    System.out.println(retVal); // prints a#1.text1
    return retVal;
} else {
    System.out.println("String doesn't match the pattern");
}