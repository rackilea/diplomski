@Test
public void searchAccountsByPartOfName() throws ParseException {
    Collection<Account> accounts = new ArrayList<>();
    Account acc1 = new new Account(..); //name having the substring "test"
    Account acc2 = new new Account(..); //surname equals "test"
    Account acc3 = new new Account(..);  //neither name nor surname has the substring "test"
    accounts.add(acc1); 
    accounts.add(acc2); 
    accounts.add(acc3);

    when(accountDao.getAll()).thenReturn(accounts);

    service.searchAccounts("test");

    Collection<Account> actual = service.searchAccounts("test");

    //here assert that the actual is of size 2 and it has the ones that pass the predicate
    assertEquals(2, actual.size());
    assertEquals(acc1, actual.get(0));
    assertEquals(acc2, actual.get(1));
}