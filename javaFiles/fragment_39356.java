public class AccountTest {
  @Test
  public void withdrawalShouldBeLogged() {
    Logger logger = mock(Logger.class);
    Account cut = new Account(logger);

    int amount = 10;
    cut.withdraw(amount);

    verify(logger).logWithdrawal(amount);
  }
}