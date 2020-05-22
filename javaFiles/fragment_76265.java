Pattern p = Pattern.compile("(\\d{4}-\\d{2}-\\d{2})");
Matcher m = p.matcher("2017-01-31 01:33:30 random text log message x");

if (m.find()) {
    System.out.println(m.group(1)); //print out the date
}