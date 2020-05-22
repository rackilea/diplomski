char from;
char to;
java.util.regex.Matcher m = java.util.regex.Pattern.compile(
    "^([\\da-fA-F]{1,4})(?:\\s*\\.\\.\\s*([\\da-fA-F]{1,4}))?$").matcher(input);
if (!m.find()) throw new IllegalArgumentException();
from = (char)Integer.parseInt(m.group(1), 16);
if (m.group(2) != null) {
    to = (char)Integer.parseInt(m.group(2), 16);
} else {
    to = from;
}