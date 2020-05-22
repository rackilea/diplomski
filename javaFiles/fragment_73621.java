public static void main(String... args) {
    List<Domino> list = new ArrayList<>();
    // [3/4] [5/6] [1/4] [1/6]
    list.add(new Domino(3, 4));
    list.add(new Domino(5, 6));
    list.add(new Domino(1, 4));
    list.add(new Domino(1, 6));

    List<Domino> chain = new ArrayList<>();
    listChains(chain, list);
}