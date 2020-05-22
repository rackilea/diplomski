/**
 * A stateful predicate that, given a total number
 * of items and the number to choose, will return 'true'
 * the chosen number of times distributed randomly
 * across the total number of calls to its test() method.
 */
static class Selector implements Predicate<Object> {
    int total;  // total number items remaining
    int remain; // number of items remaining to select
    Random random = new Random();

    Selector(int total, int remain) {
        this.total = total;
        this.remain = remain;
    }

    @Override
    public synchronized boolean test(Object o) {
        assert total > 0;
        if (random.nextInt(total--) < remain) {
            remain--;
            return true;
        } else {
            return false;
        }
    }
}