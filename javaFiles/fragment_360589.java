List<String[]> data = new ArrayList<String[]>();
for(List<String> strlist : resultList) {

    String[] array = new String[strlist.size()];
    int offset = 0;
    for(String s : strlist) {
        array[offset ++] = s;
    }
    data.add(array);
}