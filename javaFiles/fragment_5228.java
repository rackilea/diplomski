String keyValue = str.substring(str.indexOf("[") + 1, str.lastIndexOf("]"));
StringTokenizer tok = new StringTokenizer(keyValue, ",");
Map<String, String> map = new LinkedHashMap<String, String>();
while (tok.hasMoreTokens()) {
    String entString = tok.nextToken();
    map.put(entString.split("=")[0], entString.split("=")[1]);
}