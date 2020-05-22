public class Money {

    private int m;

    public Money(int m) {
        this.m = m;
    }

    public int getDollars() {
        return m / 100;
    }

    public int getCents() {
        return m % 100;
    }

    public int get() {
        return m;
    }

    public Money add(Money other) {
        return new Money(m + other.get());
    }

    public Money subtract(Money other) {
        return new Money(m - other.get());
    }
}