public static void main(String[] args) {
    List<Integer> ints = new ArrayList<Integer>(); 
    List<Double> doubles = new ArrayList<Double>(); 
    check(null);
    check(ints);
    ints.add(1);
    check(ints);
    doubles.add(1D);
    check(doubles);
}