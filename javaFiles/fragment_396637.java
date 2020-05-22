String s = "Jean-Pierre bought \"blue-green-red\" product-2345 and other blue-red stuff. yellow-black-white. product_a-b";
StringBuffer result = new StringBuffer();
Matcher m = Pattern.compile("(\"[^\"]*\")|\\b([a-zA-Z]+)-(?=[a-zA-Z]+\\b)").matcher(s);
while (m.find()) {
    if (m.group(1) != null) {
        m.appendReplacement(result, m.group(0));
    } else {
        m.appendReplacement(result, m.group(2) + " ");
    }
}
m.appendTail(result);
System.out.println(result.toString());
// => Jean Pierre bought "blue-green-red" product-2345 and other blue red stuff. yellow black white. product_a-b