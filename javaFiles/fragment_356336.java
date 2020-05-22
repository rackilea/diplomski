String text = "You have 50% off on your orders. Some texts.. Valid till 29 Jul";
Pattern pat = Pattern.compile("\\d+%");
Matcher match = pat.matcher(text);
if (match.find()) {
     System.out.println(match.group(0));
}
Pattern pat2 = Pattern.compile("\\d{1,2}\\s[A-z]{3}");
match = pat2.matcher(text);
if (match.find()) {
    System.out.println(match.group(0));
}