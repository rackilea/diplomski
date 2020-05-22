@Test
public void testRateLimitInterceptorSanityTest() {
    final RateLimitConfig config = new RateLimitConfig();
    Injector injector = Guice.createInjector(config);
    TestRateLimit testInstance = injector.getInstance(TestRateLimit.class);

    int retVal = testInstance.stubMethod();
    assertTrue(retVal == TEST_VAL);
}