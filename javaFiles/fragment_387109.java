class Instance<T, U> {

    private Function<T, U> function;

    public Instance(Function<T, U> function) {
         this.function = function;
    }
}