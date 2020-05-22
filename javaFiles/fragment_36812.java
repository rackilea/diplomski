@Test
public void testStore() throws ItemNotStoredException {
    // Arrange
    ISomeDependency serviceDependency = // create a mock dependency
    IItemsService itemSvc = new ItemsService(someDependency);

    // Act
    bool result = itemSrvc.storeItem(items);

    // Assert
    Assert.assertTrue(result);
    // assert that your dependency was used properly if appropriate
}