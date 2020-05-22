@Test
public void propertiesAreSetOnBankAccountConstructor() {
    float balance = 100F;
    char[] userNameArray = {'u'};
    char[] passArray = {'p'};
    BankAccount testedObject = new BankAccount(balance, userNameArray, passArray);

    assertEquals(balance, testedObject.getBalance(), 0F);
    assertSame(userNameArray, testedObject.getUsername());
    assertSame(passArray, testedObject.getPassword());
}