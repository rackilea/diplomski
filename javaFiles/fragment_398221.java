Pattern pattern = Pattern.compile("^\\s*(.*?)\\s+-\\s+'(.*)'\\s*$");
Matcher matcher = pattern.matcher("William Faulkner - 'Light In August'");
if (matcher.matches()) {
    String author = matcher.group(1).trim();
    String bookTitle = matcher.group(2).trim();
    ...
} else {
    // not matched, what now?
}