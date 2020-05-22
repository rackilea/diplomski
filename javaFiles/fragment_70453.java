public class KeyCounter {
    int key;
    long count;

    public KeyCounter(int key, long count) {
        this.key = key;
        this.count = count;
    }

    @Override
    public String toString() {
        return "key: " + key + " count: "  + count;
    }
}

@Test
public void foo() {
    Observable<Integer> o = Observable.just(1, 2, 3, 2, 1);
    o.groupBy(i -> i).flatMap(
        group ->
            group.subscribeOn(Schedulers.computation()).countLong().map(count -> new KeyCounter(group.getKey(), count))
    ).subscribe(System.out::println);

    try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}