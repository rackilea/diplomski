List<Integer> integers = List.list("1", "2", "3").map(new F<String, Integer>() {
    @Override
    public Integer f(String s) {
        return Integer.parseInt(s);
    }
});