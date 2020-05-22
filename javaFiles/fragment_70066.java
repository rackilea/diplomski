public interface ITest {

   public void simpleTest();
}  

public class SimpleTest implements ITest
{

   @Test
   @Override
   public void simpleTest()
   {
      Assert.assertTrue(true);
   }
}