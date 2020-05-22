public static void main(String[] args) {
    java.util.List<Int> ints = new java.util.ArrayList<>();
    ints.add(new Int(3){});
    ints.add(new Int(1){});
    ints.add(new Int(2){});
    java.util.Collections.sort(ints); // Uses compareTo
    System.out.println(ints); // Will print [1, 2, 3]
}