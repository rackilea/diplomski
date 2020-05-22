List<String> birthDates = new ArrayList<String>();
Pattern datePattern = Pattern.compile("\\d\\d-\\d\\d-\\d\\d\\d\\d");
for(String name : names) {
    Matcher m = datePattern.matcher(name);
    while(m.find()) {
        birthDates.add(m.group());
    }
}