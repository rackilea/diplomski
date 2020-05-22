String line = "@input(\"Test_1,Test_TWO , TEST_THIRTY_3*\"\\)";
String pattern = "@input\\(\"(.*?)\".*";
Pattern r = Pattern.compile(pattern, Pattern.DOTALL);
Matcher m = r.matcher(line);
while (m.find()) {
    System.out.println(Arrays.toString(m.group(1).split("\\s*,\\s*")));
    //----------------------------------------------------^^^^^^^^
}