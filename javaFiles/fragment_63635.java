//test data
Map<String, String> values = new HashMap<>();   
values.put("foo", "c");
values.put("bar", "b");
values.put("baz", "a");

for (Map.Entry<String, String> entry : values.entrySet()) {
    System.out.println(entry);
}

System.out.println("-----------sort by value-----------");

List<Map.Entry<String, String>> entries = new ArrayList(values.entrySet());
Collections.sort(entries, new Comparator<Map.Entry<String, String>>() {

    public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) { 
        return o1.getValue().compareTo(o2.getValue());
    }

});

for (Map.Entry<String, String> entry : entries) {
    System.out.println(entry);
}