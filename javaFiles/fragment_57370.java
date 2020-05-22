String [][] doubleArray = {{"a","1"},{"b","3"},{"a","1"},{"c","1"}};
Map<String, String> map = new HashMap<>();
for (String[] strings : doubleArray) {
    map.put(strings[0], strings[1]);
}
System.out.println("map = " + map);