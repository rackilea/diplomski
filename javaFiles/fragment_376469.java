String regex = "(\\d{2}/\\d{2}/\\d{4})";
Pattern pattern = Pattern.compile(regex);
Matcher matcher = pattern.matcher("current date: 01/05/2017.");
if (matcher.find()) {
    start = matcher.start(); // start index of match
    end = matcher.end(); // end index of match
    result = matcher.group(1);
}