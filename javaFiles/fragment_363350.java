Promise<String> strPromise = Promise.pure("10");
Promise<Integer> intPromise = strPromise.map(new Function<String, Integer>() {
    @Override
    public Integer apply(String arg0) throws Throwable {
        return Integer.valueOf(arg0);
    }
});