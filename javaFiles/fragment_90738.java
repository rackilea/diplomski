Map<String, String> map = new HashMap<>();
for (String part : payload.split("\\|")) {
  String[] subparts = part.split("=", 2);
  map.put(subparts[0], subparts[1]);
}
return map;