Pattern p = Pattern.compile("Here is the id\n\n\\?([a-z0-9]{2}( [a-z0-9]{2}){2})\n&Edit Properties...");
Matcher m = p.matcher(idInfo);

if (m.find()) {//or while(m.find())
    String idNum = m.group(1);
    System.out.println(idNum);
}