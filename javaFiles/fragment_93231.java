@Test
public void test() {
    Queue<Integer> q = new Queue<Integer>();      // A
    try {
        Integer ignore = q.leave();     // B
        fail("exception expected");               // C
    } catch (EmptyQueueError ex) {
        // implicit success                       // D
    }
}