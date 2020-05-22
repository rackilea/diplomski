Pattern p = Pattern.compile("\\[(.*?)\\]");
Matcher results = p.matcher("[Peter Jackson] [UK] [United Kingdom] [London]....");

while (results.find()) {
    System.out.println(results.group(1));
}