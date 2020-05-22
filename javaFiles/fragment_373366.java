List<Map<String, String>> list = new ArrayList<>();
//Add entries
Collections.sort(list, new Comparator<Map<String, String>>() {
    public int compare(Map<String, String> o1, Map<String, String> o2) {
        Collection<String> values1 = o1.values();
        Collection<String> values2 = o2.values();
        if(!values1.isEmpty() && !values2.isEmpty()){
            return values1.iterator().next().compareTo(values2.iterator().next());
        }else{
            return 0;
        }
    }
});