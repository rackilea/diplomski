String s = "Example_(xxxxx)_AND_(yyyyy)_2019-01-28";
Pattern p = Pattern.compile("(?<=[(\\[])[^()\\[\\]]*(?=[)\\]])");
Matcher m = p.matcher(s);
while (m.find()) {
    System.out.println(m.group());
}