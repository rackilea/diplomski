@Before
public void dependencyCheck() {
  // Wait for OSGi dependencies
    try {
      dependencyLatch.await(10, TimeUnit.SECONDS); 
      // Dependencies fulfilled
    } catch (InterruptedException ex)  {
      fail("OSGi dependencies unfulfilled");
    }
}