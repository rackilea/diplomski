List<String> parts = new ArrayList<String>();
boolean escaped = false;
StringBuilder stringBuilder = new StringBuilder();
for(int i = 0; i < string.length(); i++) {
    char c = string.charAt(i);
    if(!escaped && (c == ' ' || c == '\t')) {    // Space in non-escaped part
        parts.add(stringBuilder.toString());     // Put buffer in list
        stringBuilder = new StringBuilder();
    } else if (c == '"')       // Escape sign
        escaped = !escaped;    // Toggle escape status
    else
        stringBuilder.append(c);    // Add char to buffer
}
parts.add(stringBuilder.toString());    // Put the last buffer into the array