public interface ITest {
   @Test
   public void simpleTest();
} 

public class SimpleTest implements ITest
{
   @Override
   public void simpleTest()
   {
      Assert.assertTrue(true);
   }
}