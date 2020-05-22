Matcher m;
Pattern PATTERN_1=Pattern.compile("\\d+");
Pattern PATTERN_2=Pattern.compile("[a-z]+");
String text="abc";
if( ((m = PATTERN_1.matcher(text)).find()) ||
    ((m = PATTERN_2.matcher(text)).find()) ) {
    System.out.println("PATTERN: " + m.pattern());
}

// prints: PATTERN: [a-z]+