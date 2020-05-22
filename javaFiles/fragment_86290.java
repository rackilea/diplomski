@Test(expected = IllegalStateException.class)
public void testCallAfterTimeout() {
    MyObject o= new MyObject();
    // Example function that you could make
    advanceClock(1000, TimeUnit.MILLISECONDS)
    o.call();
}