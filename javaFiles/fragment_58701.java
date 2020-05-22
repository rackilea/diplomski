public List<Integer> copyToList(int[] data){
    List<Integer> list = new ArrayList<Integer>();
    for (int i = 0; i < data.length; i++) {
        list.add(data[i]);
    }
    return list;
}