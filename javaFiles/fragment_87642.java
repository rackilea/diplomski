Pattern pat2 = Pattern.compile("Quantity\\s*:\\s*(\\d+)");
int qt = -1;

Matcher matcher = pat2.matcher(Content);
if(matcher.find()) {  //we've found a match
    qt = Integer.parseInt(matcher.group(1));
}