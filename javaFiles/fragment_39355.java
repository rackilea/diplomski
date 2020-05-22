public class Account {
  private Logger logger;
  public Account(Logger logger) {
    this.logger = logger;
  }
  ...

  public void withdraw(int amount) {
    ...
    logger.logWithdrawal(amount);
    ...
  }
}