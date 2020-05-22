return Iterables.any(l2, new Predicate<Map<String, String>>() {
    @Override
    public boolean apply(Map<String, String> input) {
        return input.get("lname").equals("Jordan");
    }
});