oc.put(k1, 42);
oc.put(k2, "Hello!");
...
Integer i = oc.get(k1, Integer.class);
String s = oc.get(k2, String.class);
Integer x = oc.get(k2, Integer.class); /* Throws ClassCastException */