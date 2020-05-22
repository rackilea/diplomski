public ArrayList<Integer> mergeSort(ArrayList<Integer> list) {
    System.out.println("MERGE SORTING...");
    if (list.size() < 2)
        return new ArrayList<Integer>(list);

    ArrayList<Integer> first = new ArrayList<Integer>(list.subList(0, list.size() / 2));
    ArrayList<Integer> second = new ArrayList<Integer>(list.subList(list.size()/2, list.size()));

    return merge(mergeSort(first), mergeSort(second));
}