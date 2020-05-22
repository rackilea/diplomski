// similar as before, but captures the value for "name" 
// and validates with "=characters" after it
static final Pattern NAME_VALUE = Pattern.compile("^\\s*name\\s*=\\s*(.+)");
// ...
Matcher m = NAME_VALUE.matcher(line);
if (m.find()) {
    // "jake"
    String myValue = m.group(1);
}