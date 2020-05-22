final List<String> strList = Arrays.asList("1,2,3,4,5".split(","));
final List<Long> l = Lists.transform(strList, new Function<String, Long>() {
    @Override
    public Long apply(final String input) {
        return Long.parseLong(input);
    }
});