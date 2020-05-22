public class ConcreteTest extends BaseTest  {

    @Override
    public List<Object[]> extraParams() {
        List<Object[]> list = ...//set up data here
        return list;
    }   

    @Test
    public void test1() {
        Object[] testData = myProjectTestRule.getTestData();
        //use the test data for the test
        //Example: Assume addition of two integers scenario and data 
        //data[0] expectedresult, data[1],[2] inputs
        //Assert.assertEquals((int)data[0], (int)(data[1]+data[2]));

    }

    //add other test cases
}