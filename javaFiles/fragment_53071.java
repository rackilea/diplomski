@Test
public void pojoClassTest() throws Exception {
    List<PojoClass> sourcePojoList = getSourcePojoList();
    List<PojoClass> targetPojoList = getTargetPojoList();
    try {
        Assert.assertArrayEquals(sourcePojoList.toArray(), targetPojoList.toArray());
    }
    catch (ArrayComparisonFailure e) {
        Assert.fail(getMessage(e));
    }
}