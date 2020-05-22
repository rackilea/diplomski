class C<T extends String> {
    List<Set<T>> sets = new ArrayList<>();

    public C() {
        sets.add(new HashSet<String>()); // does not compile
        sets.add(new HashSet<Integer>()); // does not compile
    }
}