List<String> strs = Arrays.asList("TEST1 AVOID TEST2 2016 TEST3 TEST4", "TEST1 TEST2 2016 TEST3 TEST4", "TEST1 TEST2 2016 TEST3 TEST4 AVOID");
String pat = "^(?!.*\\bAVOID\\b).*?\\b(\\d{4})\\b";
for (String str : strs) {
    Matcher m = Pattern.compile(pat).matcher(str);  
    if (m.find()) {
        System.out.println(m.group(1));   // return m.group(1)
    } else {
        System.out.println("No match for " + str + " :("); // return "" here
    }
}