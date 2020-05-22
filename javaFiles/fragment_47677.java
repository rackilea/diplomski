private static final Pattern FILENAME_PATTERN =
    Pattern.compile("(?:[^~]*~){5}~([^~]*)\\.csv");

Matcher m = FILENAME_PATTERN.matcher(mf.getName());
if (!m.matches) ... do what you want
String timestamp = m.group(1);