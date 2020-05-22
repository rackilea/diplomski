@Test
public void testWakeup() throws Exception {
    Thread t = new Thread(new UserA());
    t.start();
    t.join();
}