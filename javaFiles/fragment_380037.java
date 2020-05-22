BiPredicate<List<Integer>,Integer> listContains = new BiPredicate<>() {
    @Override
    public boolean test(List<Integer> list, Integer num) {
        return list.contains(num);
    }
};