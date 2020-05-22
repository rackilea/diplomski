Map<String, String> m = new HashMap<String, String>(); 
m.put("lebron", "james");
m.put("kevin", "durant");

Joiner.MapJoiner joiner = Joiner.on(",").withKeyValueSeparator("");
System.out.println(joiner.join(m));  // return lebronjames,kevindurant