String s = "<div id=\"tt\" class=\"info\">\n  Text Here   \n</div>";
System.out.println(s);
Pattern p = Pattern.compile("<div id=\"tt\" class=\"info\">\\s*([^<]+?)\\s*</div>", Pattern.DOTALL);
Matcher m = p.matcher(s);
if (m.find()) {
    System.out.println(m.group(1));  // Text Here
}