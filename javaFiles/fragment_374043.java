Pattern p = Pattern.compile("^JWE-([0-9]+)\\.([0-9]+)\\.pdf$");
Matcher m = p.matcher("your string here");

if (m.find()) {
    System.out.println(m.group(1)); //first number group
    System.out.println(m.group(2)); //second number group
}