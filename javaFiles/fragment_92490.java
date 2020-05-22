String usefulData = "[a],[b],[c,d]";
String token = Pattern.quote("],[");
String[] list = usefulData.split(token);

for (String val: list) {
    System.out.println(val.replaceAll("\\[|\\]", ""));
}