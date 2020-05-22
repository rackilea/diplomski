private static void interleave(ArrayList<Integer> a1, ArrayList<Integer> a2) {
    int i = -1;
    for(Integer elem: a2) {
        if(i < a1.size()-1) {
            i += 2;
        } else {
            i += 1;
        }
        a1.add(i, elem);
    }
}

public static void main(String[] args) throws Exception {

    ArrayList<Integer> a1 = new ArrayList<>(Arrays.asList(10, 20, 30));
    ArrayList<Integer> a2 = new ArrayList<>(Arrays.asList(4, 5, 6, 7, 8));

    interleave(a1, a2);
    System.out.println(a1);
}