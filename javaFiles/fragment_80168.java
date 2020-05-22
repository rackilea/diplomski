String arr[] = {"12341234abc", "1234foo1234", "12121212", "111111111", "1a1212b123123c12341234d1234512345"};
String regex = "(\\d+?)\\1";
Pattern p = Pattern.compile(regex);
for (String elem : arr) {
    boolean noMatchFound = true;
    Matcher matcher = p.matcher(elem);
    while (matcher.find()) {
        noMatchFound = false;
        System.out.println(elem + " got repeated: " + matcher.group(1));
    }
    if (noMatchFound) {
        System.out.println(elem + " has no repeation");
    }
}