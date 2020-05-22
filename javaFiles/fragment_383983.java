Hashtable<String, Integer> tab = new Hashtable<>();
 tab.put("A", new Integer(42));

 // Unchecked conversion
 Hashtable<String, String> bad = (Hashtable<String, String>) tab;

 String res = bad.get("A");    // Ooops!