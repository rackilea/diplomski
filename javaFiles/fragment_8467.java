String s = "Müller";

Pattern p = Pattern.compile("^\\w+$", Pattern.UNICODE_CHARACTER_CLASS);
Matcher m = p.matcher(s);
if (m.find()) {
    System.out.println(m.group());
} else {
    System.out.println("not found");
}