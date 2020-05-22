Pattern pattern = Pattern.compile("(\\w+)#?");
Pattern check = Pattern.compile("^[\\w#]+$");
if (!check.matcher(input).matches()) // As requested: Sanity check
    throw new IllegalArgumentException("Bogus input received :(");
Matcher m = pattern.matcher(input);
while (m.find()) {
    String matched = m.group(1); // Iterates over the occurences
    System.out.println("I found " + matched);
}