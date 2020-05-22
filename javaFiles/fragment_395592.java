Pattern pattern = Pattern.compile("What is|Address is");
Matcher matcher = pattern.matcher(namee);
if (matcher.find()) {
    if (matcher.group().equals("What is")) {
        namee = "name";
    }
}