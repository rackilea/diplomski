String a, b, c;

MultiMap mMap = new MultiValueMap();
mMap.put("a", "Hello there, It's a wonderful day");
mMap.put("a", "nice to meet you");

Set<String> keys = mMap.keySet();

for (String key : keys) {
    System.out.println("Key = " + key);
    System.out.println("Values = " + mMap.get(key));
    List<String> list = (List<String>) mMap.get(key);

    b = list.get(0);
    c = list.get(1);
    System.out.println("B : " + b);
    System.out.println("C : " + c);
}