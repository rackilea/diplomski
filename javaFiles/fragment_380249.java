Pattern p = Pattern.compile("^c\\\\cert\\\\ \"([^\"]+)\" text\r?\n" +
                            "(--Begin Cert\r?\n.*?\r?\n--End Cert)[\r\n]*",
                            Pattern.MULTILINE | Pattern.DOTALL);
Matcher m = p.matcher(input);
while (m.find()) {
    System.out.println("Key:" + m.group(1));
    System.out.println("value:\"" + m.group(2) + "\"");
    System.out.println();
}