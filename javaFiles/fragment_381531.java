Map<String, String> map = new HashMap<>();
map.put("x", "abcd");
map.put("y", "qwert");
map.put("z", "mnvji");
Scanner s = new Scanner(System.in);
while (s.hasNextLine())
System.out.println(map.get(s.nextLine()));