String input = "v={YYYYMMDD}";
String regex = "^v=\\{([^}]{8})\\}$";

Matcher m = Pattern.compile(regex).matcher(input);

if (m.find()) {
    System.out.println("Date pattern - " + m.group(1));
} else {
    System.out.println("No date found!");
}