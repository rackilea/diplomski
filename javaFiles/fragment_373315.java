public class PersonTest {
    private static final String TEST_FIRST_NAME = "some name";

    Person target;

    // ...
    @Test
    public void testSetFirstName() {
        target.setFirstName(TEST_FIRST_NAME);
        Assert.assertEquals(target.getFirstName(), TEST_FIRST_NAME);
    }
}