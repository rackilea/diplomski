HashMap<String, Integer> map = new HashMap<String, Integer>();
map.put("a", 4);
map.put("c", 6);
map.put("b", 2);
Object[] a = map.entrySet().toArray();
Arrays.sort(a, new Comparator() {
    public int compare(Object o1, Object o2) {
        return ((Map.Entry<String, Integer>) o2).getValue()
                   .compareTo(((Map.Entry<String, Integer>) o1).getValue());
    }
});
for (Object e : a) {
    System.out.println(((Map.Entry<String, Integer>) e).getKey() + " : "
            + ((Map.Entry<String, Integer>) e).getValue());
}