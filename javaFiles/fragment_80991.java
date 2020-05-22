Map<Integer, String> map = new HashMap<>();
map.put(0, "$");
map.put(1, "|");
map.put(2, "*");
for(Map.Entry<Integer, String> m: map.entrySet()) {
    if(m.getValue().equals("$")) {
        System.out.println(m.getKey() + ":" + m.getValue());
    }           
}