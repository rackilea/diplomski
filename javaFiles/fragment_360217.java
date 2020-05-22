Pattern p = Pattern.compile("\\\\0..([^=]+)=([^\\\\]*)");
Matcher matcher = p.matcher("\\018attribute1=value1\\028attribute2=value2\\033attribute3=value3");
Map<String, String> attributes = new HashMap<String, String>();
while (matcher.find()) {
    attributes.put(matcher.group(1), matcher.group(2));
}