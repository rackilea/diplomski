String value = "<tag TAG1>SOME VALUE</tag TAG1><tag TAG1>ANOTHER VALUE</tag TAG1>";
Pattern pattern = Pattern.compile("<\\s*tag\\s*[^>]+\\s*>([^(</)]*)</\\s*tag\\s*[^>]+\\s*>");
Matcher matcher = pattern.matcher(value);
while (matcher.find()) {
    System.out.println(matcher.group());
}