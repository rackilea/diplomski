StringBuilder s = new StringBuilder();
for(Map.Entry<String,List<String>> entry : map.entrySet()) {
   s.append(entry.getKey() + "\n");
   List<String> list = entry.getValue();
   for(String item : list) {
      s.append("   " + item + "\n");
   }
}
return s.toString();