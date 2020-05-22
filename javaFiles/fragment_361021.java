Map m = new HashMap();
m.put("one", "uno");

// This would give a compiler error, because although we know
// we'll get a String back, all the compiler knows is that it's
// an Object
String italian = m.get("one");

// This works, we're telling the compiler "trust me, it's a String"
String italian = (String)m.get("one");