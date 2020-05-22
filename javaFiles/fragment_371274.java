public static void main (String[] argv) {
  Map<String, String> h = new HashMap<String, String>();

  // Insert a string and a key.
  h.put("Ali", "Anorexic Ali");
  h.put("Bill", "Bulimic Bill");
  h.put("Chen", "Cadaverous Chen");
  h.put("Dave", "Dyspeptic Dave");

  String d = h.get("Dave");
  System.out.println (d);  // Prints "Dyspeptic Dave"
}