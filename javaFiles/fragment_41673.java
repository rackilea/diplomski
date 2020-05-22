@Test
public void example(@Mocked final DataAccessLayer<UtilClass> mock)
{
    final UtilClass data = new UtilClass(123);
    new Expectations() {{ mock.getData(UtilClass.class, 1); result = data; }};

    int result = new ServiceLayer().testingMethode();

    assertEquals(123, result);
}