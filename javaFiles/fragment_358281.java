String str = "abc@roin.com";

Pattern pattern = Pattern.compile("\\S+?@roin\\.com");
Matcher matcher = pattern.matcher(str);

if (matcher.matches()) {
    System.out.println("Matches"); // Prints this for this email
}