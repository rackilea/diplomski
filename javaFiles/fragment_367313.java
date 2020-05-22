Set<String> s = v.get("AHA");
if (s==null) {
    s = new HashSet<String>();
    v.put("AHA", s);
}
s.add("BA");