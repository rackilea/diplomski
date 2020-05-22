HashMap < String, Integer > hmap = new HashMap < Integer, String > ();
for (str: tokens) {
    if (hmap.get(str) == null) hmap.put(str, 1);
    else hmap.put(str, hmap.get(str) + 1);
}
Iterator it = hmap.iterator();
while (it.hasNext()) {
    Map.Entry pair = (Map.Entry) it.next();
    System.out.println(pair.getKey() + " = " + pait.getValue());
    it.remove();
}