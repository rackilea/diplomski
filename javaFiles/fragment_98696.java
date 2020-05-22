@Test
public void testAdditionalMethod()
{
    OtherInterface oi = (OtherInterface) dao;
    System.out.println(oi.additionalMethod(...));
}