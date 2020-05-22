Pattern p = Pattern.compile("^.*?\\/([^\\/]+?\\/[^\\/]+?$)");
Matcher m = p.matcher(string);

if (m.find()) {
    System.out.println(m.group(1));
}