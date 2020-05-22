@Rule 
public MockitoRule mockitoRule = MockitoJUnit.rule(); 
@Mock
private AccountMergerInterface accountMergerInterface;
@Mock
private AccountInterface accountInterface;
@Test
public void testMigrateUser() {
    // arrange
    when(test.performChange()).thenReturn(true);
    // act
    new UserInterfaceImpl(accountInterface).migrateUser(accountMergerInterface);
    // assert
   InOrder inOrder Mockito.inOrder(accountMergerInterface, accountInterface);
   inOrder.verify(accountMergerInterface).deposit(1);
   inOrder.verify(accountInterface).whatEverToCallNext();
}