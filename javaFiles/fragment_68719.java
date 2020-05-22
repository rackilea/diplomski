StringBuilder builder = new StringBuilder(plainText.length());
while (builder.length() < plainText.length()) {
    builder.append(key.substring(0, Math.min(key.length(),
                                        builder.length() - plainText.length()));
}
String result = builder.toString();