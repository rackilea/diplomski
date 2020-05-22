Pattern pat = Pattern.compile("SKU\\s*:\\s*(\\S+)");
String sku = null;

Matcher matcher = pattern.matcher(Content);
if(matcher.find()) {  //we've found a match
    sku = matcher.group(1);
}
//do something with sku