public class AnimalTest
{
    // Both tested and (partially) mocked:
    @Tested @Mocked Animal animal;

    @Test
    public void testMethodNWhileMockingMethods1And2()
    {
        // Recorded methods will be mocked:
        new Expectations() {{
            animal.method1();
            animal.method2();
        }};

        // Methods not recorded execute normally.
        animal.methodN();
    }

    @Test
    public void testMethodNWhileExecutingMethods1And2AndAlsoVerifyingTheyWereCalled()
    {
        animal.methodN();

        // Executed methods can still be verified:
        new Verifications() {{
            animal.method1();
            animal.method2();
        }};
    }
}