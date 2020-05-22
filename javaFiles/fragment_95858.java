String REGEX = "^(?=.*license).*GNU";
String contents1 = "This  licensed using GNU version 2 .";
Matcher m = Pattern.compile(REGEX).matcher(contents1);
if (m.find()) {
    System.out.println("Found!");
}