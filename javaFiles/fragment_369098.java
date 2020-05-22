private static final String WHITESPACE = " ";

String yourOldString;
String freshString;
StringBuilder builder = new StringBuilder();
builder.append(yourOldString);

// other code which updates freshString
builder.append(WHITESPACE);
builder.append(freshString);

// once everything is done:
String resultString = builder.toString();