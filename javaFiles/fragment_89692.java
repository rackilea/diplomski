public class SomeTest
{
   @Autowired UnitUnderTest unitUnderTest;
   @Mocked ISomeInterface theMock; // created and assigned automatically

   @Test
   public void testSomeMethod()
   {
      Deencapsulation.setField(unitUnderTest, theMock);
      //proceed with unit test here
   }
}