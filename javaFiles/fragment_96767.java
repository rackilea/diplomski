String string = "hello";
Hashtable<Character, Integer> map = new Hashtable<>();
for (int i = 0; i < string.length(); i++) {
   char c = string.charAt(i);
   if (map.containsKey(c)) {
      map.put(c, map.get(c) + 1);
   } else {
      map.put(c, 1);
   }
}
System.out.println(map);