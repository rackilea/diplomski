@Test
public void propertiesAreSetOnBankAccountConstructor() {
    float balance = 100F;
    char[] userNameArray = {'u'};
    char[] passArray = {'p'};
    BankAccount testedObject = new BankAccount(balance, userNameArray, passArray);

    assertEquals(balance, ((Float)ReflectionTestUtils.getField(testedObject, "balance")), 0F);
    assertSame(userNameArray, ReflectionTestUtils.getField(testedObject, "username"));
    assertSame(passArray, ReflectionTestUtils.getField(testedObject, "password"));
}