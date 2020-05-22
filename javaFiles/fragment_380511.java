final String logEntryPattern = "(\\w+\\s+\\d+\\s+\\d{2}:\\d{2}:\\d{2})\\s+(\\S+)\\s+(\\S+):\\s+(.+)";
final Pattern p = Pattern.compile(logEntryPattern);
final Matcher matcher = p.matcher(line);

if (!matcher.matches()) {
    System.err.println("Regular Expression not matching:");
    System.err.println(line);
    return;
}
System.out.println("Total groups: " + matcher.groupCount());
System.out.println("Date&Time: " + matcher.group(1));
System.out.println("Hostname: " + matcher.group(2));
System.out.println("Program Name: " + matcher.group(3));
System.out.println("Log: " + matcher.group(4));