public class NumberList implements Iterable<Number> {

    private int numItems;
    private Number[] numbers;

    public NumberList(int size) {
        this.numbers = new Number[size];
        this.numItems = 0;
    }

    public void add(Number n) {
        this.numbers[this.numItems++] = n;
    }

    @Override
    public Iterator<Number> iterator() {
        return Arrays.asList(numbers).subList(0, numItems).iterator();
    }
}