String stringToSearch = "https://example.com/excludethis123456/moretext";

Pattern p = Pattern.compile("(?<=.com/excludethis).*(?=/)"); // search for this pattern
Matcher m = p.matcher(stringToSearch); // match pattern in StringToSearch

String store = "";

// print match and store match in String Store
if (m.find()) {
    String theGroup = m.group(0);
    System.out.format("'%s'\n", theGroup);
    store = theGroup;
}
System.out.println("Store: " + store);