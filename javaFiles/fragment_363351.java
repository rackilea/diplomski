intPromise.onRedeem(new Callback<Integer>() {
    @Override
    public void invoke(Integer arg0) throws Throwable {
        System.out.println("Promiss redeemed: " + arg0);
    }
});
intPromise.onFailure(new Callback<Throwable>() {
    @Override
    public void invoke(Throwable arg0) throws Throwable {
        System.out.println(arg0);
    }
});