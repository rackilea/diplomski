Map<Integer,String> val1 = a.get(2.34);
if (val1 == null) {
    val1 = new TreeMap<Integer, String>();
    a.put(2.34, val1);
}
val1.put(4, "I'm a long String");