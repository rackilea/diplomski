List<String[]> myList = new ArrayList<String[]>();

myList.add(new String[]{"a","g","x"});
myList.add(new String[]{"c","f","y"});
myList.add(new String[]{"b","d","z"});

Collections.sort(myList, new Comparator<String[]>() {
    @Override
    public int compare(String[] o1, String[] o2) {
    return o1[0].compareTo(o2[0]);
    }
});