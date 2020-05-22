List<String[]> list = new ArrayList<String[]>();

list.add(new String[]{"Hello", "", null, "Jack"});
list.add(new String[]{});

for(String[] array : list){
    List<String> arrayList = new ArrayList<>(Arrays.asList(array));
    arrayList.removeAll(Collections.singleton(null));
    arrayList.removeAll(Collections.singleton(""));
    array = arrayList.toArray(new String[arrayList.size()]);
    System.out.println(Arrays.toString(array));
}