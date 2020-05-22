private static final Pattern PATTERN = Pattern.compile("\\$F\\{ETIQ\\d\\}");

// ...

final Matcher m = PATTERN.matcher(textField.getText());

while (m.find())
    // work with m.group()