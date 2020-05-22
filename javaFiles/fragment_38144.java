public class Money {
    private volatile double amount;

    public Money(double amount) {
        super();
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public synchronized void setAmount(double amount) {
        this.amount = amount;
    }

    public synchronized Money multiplyBy( int factor) {
        this.amount *= factor;
        return this;
    }
}