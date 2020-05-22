public static void main(String[] args) throws Exception {
    List<Integer> random = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    Collections.shuffle(random);

    List<String> someList = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k");

    for (int i : random) {
        System.out.print(someList.get(i));
    }
}