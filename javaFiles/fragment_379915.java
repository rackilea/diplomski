public final class MyClass {

    private final RandomNumberGenerator randomNumberGenerator;
    private final IntConsumer somethingDoer;

    public MyClass(
            RandomNumberGenerator randomNumberGenerator,
            IntConsumer somethingDoer) {
        this.randomNumberGenerator = randomNumberGenerator;
        this.somethingDoer = somethingDoer;
    }

    public void doSomethingRandomLotsOfTimes() {
        for(int i=0; i<10; i++) {
            int r = randomNumberGenerator.next();
            somethingDoer.consume(r);
        }
    }
}