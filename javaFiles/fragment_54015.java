public static void main(String[] args) {
    DArray<Integer> t = new Dinaminis<Integer>(Integer.class);
    for (int i = 0; i < 11; i++) {
        t.ideti(i);
    }
    System.out.println(t);
}