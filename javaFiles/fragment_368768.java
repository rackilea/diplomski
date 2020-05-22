public static ArrayList<Integer> removeAllDuplicates(ArrayList<Integer> list) {
    Collections.sort(list);
    int i = 0;
    while(i < list.size() - 1) {
        if (list.get(i) == list.get(i + 1)) {
            list.remove(i);
        } else {
            i++;
        }
    }
    return list;
}