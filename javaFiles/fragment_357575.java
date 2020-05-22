class Pair<A, C> {
    public final A a;
    public final C c;

    Pair(A a, C c) {
        this.a = a;
        this.c = c;
    }
}

public static void main(String[] args) {
    List<Pair<Integer,Integer>> list = new ArrayList<>();
    list.add(new Pair<>(2,-1));
    list.add(new Pair<>(3,2));
    list.add(new Pair<>(4,1));
    Collections.sort(list,
            (Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) -> o1.c.compareTo(o2.c));
    list.stream().forEach((pair) -> {
        System.out.println(pair.a + " " + pair.c);
    });
}