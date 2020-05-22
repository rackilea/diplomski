String myString = "@123.45";
String returned = null;

Pattern p = Pattern.compile("^@([+-]?\\d+(?:\\.\\d+)?)$");
Matcher m = p.matcher(myString);

if(m.find()) {
    returned = m.group(1);
}