@Before
public void setUp() throws Exception {
    activity = testRule.getActivity();
    latch = new CountDownLatch(1);
}

@Test
public void testSimpleSetup() {

    /* ... */

    InstrumentationRegistry.getInstrumentation().runOnMainSync(new Runnable() {
        @Override
        public void run() {
            testManager.startTest(MAX_WAIT_TIME); // this object calls onTestResult(boolean) after time t (t <= MAX_WAIT_TIME)

            /* working with activity here */
        }
    });
    InstrumentationRegistry.getInstrumentation().waitForIdleSync();

    latch.await(); // here we block test thread and not UI-thread
                   // presumably, you will want to set the timeout here
}

@Override
public void onTestResult(boolean passed) {
    // assertTrue(passed);
    Assert.fail();
    latch.countDown();
}