// Predicate<String> predicate = s -> s.isEmpty();
Predicate<String> predicate = new Predicate<String>() {
    @Override
    public boolean test(String s) {
        return s.isEmpty(); // returns boolean here
    }
};