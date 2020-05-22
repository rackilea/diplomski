class BadExample {
    private volatile int counter;

    public void hit(){
        /* This operation is in fact two operations:
         * 1) int tmp = this.counter;
         * 2) this.counter = tmp + 1;
         * and is thus broken (counter becomes fewer
         * than the accurate amount).
         */
        counter++;
    }
}