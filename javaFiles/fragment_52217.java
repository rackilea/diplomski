Map m = new HashMap<Integer, String>();
m.put(1, "one");
m.put(2, "two");
m.put(3, "three");

// Iterate the keys in the map
for (Entry<Integer, String> entry : m.entrySet()){
    if (entry.getKey().equals(Integer.valueOf(2)){
        System.out.println(entry.getValue());
    }
}