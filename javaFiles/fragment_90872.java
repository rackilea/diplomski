return promiseBool.map(new Function<Boolean, Result>() {
    @Override
    public Result apply(Boolean bool) throws Throwable {
        Result res = ok();
        return res;
    }
}).recover(new Function<Throwable, Result>() {
    // Same
});