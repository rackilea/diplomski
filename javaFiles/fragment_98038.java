public class Test {

    private Map<Animal, Set<Integer>> m = new EnumMap<>(Animal.class);

    public Test() {
        m.put(Animal.DOG, Set.of(1, 2, 3));
        m.put(Animal.FISH, Set.of(4, 5, 6));
    }

    public static void main(String[] args) {
        Test t = new Test();
        t.addValueIfNotPresent(Animal.CAT, 2);
        t.addValueIfNotPresent(Animal.CAT, 5);
        t.addValueIfNotPresent(Animal.CAT, 7);

        System.out.println(t.m);
    }

    private void addValueIfNotPresent(Animal key, Integer value) {
        if (m.values().stream().flatMap(Collection::stream).noneMatch(value::equals)) {
            m.compute(key, (animal, integers) -> {
                if (Objects.isNull(integers)) {
                    Set<Integer> s = new HashSet<>();
                    s.add(value);
                    return s;
                } else {
                    integers.add(value);
                    return integers;
                }
            });
        }
    }

    enum Animal {DOG, CAT, FISH}
}