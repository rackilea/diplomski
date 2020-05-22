public class TestExecute{

TestNGDataProvider tg=new TestNGDataProvider();

@Test(dataProvider = "Authentication",dataProviderClass = TestNGDataProvider.class)
 public void test1(String login,String user,String pass) throws InterruptedException {

    tg.testMethod1(login,user,pass);
}
 }