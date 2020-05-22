List<String> keys = new ArrayList<>();
keys.add("case 10");        
keys.add("case 3");        
keys.add("case 1");
keys.add("case 2");        
Collections.sort(keys, new Comparator<String>() {

    @Override
    public int compare(String s1, String s2) {
        s1 = s1.split(" ")[1];
        s2 = s2.split(" ")[1];
        return Integer.compare(Integer.parseInt(s1), Integer.parseInt(s2));
    }
});

for (String key : keys) {
    System.out.println(key);
}