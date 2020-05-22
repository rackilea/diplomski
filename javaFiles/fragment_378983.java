public static void add(List<Integer> list, Integer value) {
    int index = Collections.binarySearch(list, value);
    list.add((index < 0) ? (-index - 1) : index, value);
}

public static void main(String[] args) {
    List<Integer> list = new ArrayList<Integer>();

    add(list, 1);
    add(list, -5);
    add(list, -7);
    add(list, 100);
    add(list, 0);
    add(list, 90);
    add(list, -10);
    add(list, 0);
    add(list, 1);

    System.out.print(list);
}