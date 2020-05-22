public class UserTest {

    @Mocked
    Creator creator;


    @DataProvider(name = "my data provider")
    public Oject[][] dataProvider() {
    //code data proviver
    }


    @Test(dataProvider = "my data provider")
    public void testRemove(int id, String name) {
        new Expectations() {{
            creator.doSomething(...);
            result = expectedResult;

            //other expectation
        }};
        //other test code
    }
}