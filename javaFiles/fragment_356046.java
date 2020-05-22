@RunWith(PowerMockRunner.class)
@PrepareForTest(B.class)
class TestClassAWithPowerMockito{
    @Test
    public void testVeryImportantMethod() throws Exception {
        A a = new A();
        PowerMockito.suppress(PowerMockito.method(B.class, "veryAnnoyingMethod", int.class, short.class));
        a.veryImportantMethod();
        ...
    }
}