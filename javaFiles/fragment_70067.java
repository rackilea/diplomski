public abstract class ATest {

   @Test
   public abstract void simpleTest();
} 

public class SimpleTest extends ATest
{
   @Override
   public void simpleTest()
   {
      Assert.assertTrue(true);
   }
}  

public class SecondTest extends ATest
{
   @Override
   public void simpleTest()
   {
      Assert.assertFalse(false);
   }
}