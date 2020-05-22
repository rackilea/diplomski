public class SoftAsert
{
@Test
public void test()
{
    SoftAssert asert=new SoftAssert();
    asert.assertEquals(false, true,"failed");
    asert.assertEquals(0, 1,"brokedown");
    asert.assertAll();
}
}