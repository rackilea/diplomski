// Match (and group) one more characters followed by a "," and
// optional whitespace. Then match (and group) one character followed
// any number of optional characters.
private static Pattern pattern = Pattern.compile("(.+),\\s*(.).*");
public static String formatName(String name) {
    Matcher m = pattern.matcher(name);
    if (m.matches()) {
        return String.format("%s. %s", m.group(2), m.group(1));
    }
    return name;
}