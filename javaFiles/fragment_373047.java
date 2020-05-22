public static void main(String[] args) {
    ArrayList<Integer> a = fillArray(20,1,25);
    System.out.println("unsorted array");
    for (Integer c : a)
        System.out.print(c + ";");
    ArrayList<Integer> b = sorter(a);
    System.out.println("\nnew unsorted array");
    for (Integer c : a)
        System.out.print(c + ";");
    System.out.println("\nsorted array");
    for (Integer c : b)
        System.out.print(c + ";");
}