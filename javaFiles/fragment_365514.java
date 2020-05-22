class Trust {
    private AtomicInteger balance = new AtomicInteger(0);
    public void deposit(int amount) {
        int newBalance = this.balance.addAndGet(amount);
        System.out.println(Thread.currentThread().getName() +
                           "; Balance " + newBalance);
    }
}