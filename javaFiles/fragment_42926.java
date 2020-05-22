String file = "Call_Report_Jan_15_2015_0804AM.csv";
Pattern p = Pattern.compile("[a-zA-Z]+_[0-9]+_[0-9]+_[0-9]+[a-zA-Z]+");
Matcher matcher = p.matcher(file);
if (matcher.find()) {
    int startIndex = matcher.start();
    int endIndex = matcher.end();
    String group = matcher.group();
    System.out.println(group);
}