String input = "Key: \"employeeNo\" with value \"ABC12345\" is already used.";
Pattern p = Pattern.compile("Key: \"employeeNo\" with value \"(ABC\\d+)\" is already used.");
Matcher m = p.matcher(input);
if (m.find()) {
    System.out.println(m.group());
    System.out.println(m.group(1));
}