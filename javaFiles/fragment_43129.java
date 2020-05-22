final String regex = "\\b(?:\\d{1,2}/*\\d{1,2}/)?\\d{4}_(?:CARD|CD)(?:\\h*[-_]+)?\\h*";

final Pattern pattern = Pattern.compile(regex);
final Matcher matcher = pattern.matcher(input);

// The substituted value will be contained in the result variable
final String result = matcher.replaceAll("");

System.out.println("Substitution result: " + result);