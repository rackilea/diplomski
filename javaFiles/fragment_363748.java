public class Test {
    public static class Bar {
        public Bar(Integer id) {
            this.id = id;
        }

        Integer id;
    }

    public static class Foo {
        private List<Bar> bars = new ArrayList<>();

        public List<Bar> getBars() {
            return bars;
        }
    }

    public static void main(String[] argb) {
        Foo nullFoo = null;
        Optional<List<Integer>> nullList = convertToIdList(nullFoo);
        System.out.println(nullList); // Optional.empty

        Foo notNullFoo = new Foo();
        notNullFoo.getBars().add(new Bar(3));
        notNullFoo.getBars().add(new Bar(4));
        notNullFoo.getBars().add(new Bar(5));
        Optional<List<Integer>> notNullList = convertToIdList(notNullFoo);
        System.out.println(notNullList); // Optional[[3, 4, 5]]
    }

    private static Optional<List<Integer>> convertToIdList(Foo foo) {
        return Optional.ofNullable(foo).map(Foo::getBars).map(y -> y.stream().map(z -> z.id).collect(Collectors.toList()));
    }
}