private static String getDate(String str) {
    Pattern regex = Pattern.compile("\\.*(?<date>([0-9]{4}\\/[0-9]{2}\\/[0-9]{2}))");
    Matcher matcher = regex.matcher(str);
    boolean success = matcher.find();
    return (success ? matcher.group("date") : null);
}

// Example:
String dateStr = getDate("DataFileDownload/FD/722066/71493/2016/12/30/untitled-1.aux");