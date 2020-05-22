Pattern p = Pattern.compile("^\\d{2}\\.\\d{3}\\.\\d{3}-[A-Z]$", Pattern.MULTILINE);
Matcher matcher = pattern.matcher(text);

// check occurrence
while (matcher.find()) {
    System.out.println("ok");
}