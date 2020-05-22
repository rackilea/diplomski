@Test
public void simpleTestFailure() {
    check(
            () -> Assert.assertEquals(true, false),
            () -> Assert.assertEquals(5, 5));
}

@Test
public void simpleTestOK() {
    check(
            () -> Assert.assertEquals(5, 5));
}

private void check(Runnable... runnables) {
    boolean success = true;
    int index = 0;
    for (Runnable runnable : runnables) {
        try {
            index++;
            runnable.run();
            System.out.println(String.format("Assertion %s succeeded", index));
        } catch (AssertionError ae) {
            System.err.println(String.format("Assertion %s failed:\n%s", index, ae));
            ae.printStackTrace(System.err);
            success = false;
        }
    }
    Assert.assertTrue(success);
}