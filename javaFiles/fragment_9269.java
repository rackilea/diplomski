private Thread lastThread;

public void transferMoney(Account account, Account account2, int amount) {
  Thread t = lastThread;
  if (t != null)
      t.stop(); // so another thread running this immediately on a random line.
  lastThread = Thread.currentThread();
  // lastThread could die here
  if (account1.withdrawn(amount)) { // the withdraw was successful
      // lastThread could die here
      account2.deposit(amount);
  }
  // lastThread could die here
  lastThread = null;
}