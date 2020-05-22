@Test
public void testGetFruitItemMap() {
    Map<String, Fruit> fruitItemMap = new HashMap<>();
    FruitItemImpl doa1 = Mockito.spy(dao);
    Mockito.doReturn(fruitItemMap.values().iterator()) // Here!
           .when(doa1).getAllItemsBelongingToApple("Apple");
    Assert.assertEquals(fruitItemMap.size(), doa1.getFruitItemMap().size());
}