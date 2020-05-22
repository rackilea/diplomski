Map<String, String> properties = new HashMap<>();
properties.put("lang", "java");
properties.put("java.version", "1.8");

String s = "This is {{lang}.version}.";

Pattern p = Pattern.compile("\\{([^{}]+)\\}");
Matcher m = p.matcher(s);
while(m.find()){
    String key = m.group(1);
    s = m.replaceFirst(properties.get(key));
    System.out.println(s);
    m = p.matcher(s); //Reset the matcher
}