// Make sure we never have to expand...
StringBuilder builder = new StringBuilder(plainText.length() + key.length() - 1);
while (builder.length() < plainText.length()) {
    builder.append(key);
}
builder.setLength(plainText.length());
String result = builder.toString();