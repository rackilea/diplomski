public static void main(String[] args) {
    List<Pair<Integer,Integer>> list = new ArrayList<>();
    list.add(new Pair<>(2,-1));
    list.add(new Pair<>(3,2));
    list.add(new Pair<>(4,1));
    Collections.sort(list);
    list.stream().forEach((pair) -> {
        System.out.println(pair.a + " " + pair.c);
    });
}