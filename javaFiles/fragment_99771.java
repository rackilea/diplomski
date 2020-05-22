public class SavingsAccount()
    {
      private static int nextAccountId = 1001;
      private int accountId;
      private double balance = 0.0;

      private int getNextAccountId()
      {
          return nextAccountId++;
      }

      public SavingsAccount()
      {
        accountId = getNextAccountId();
      }

      public int getAccountId()
      {
          return accountId();
      }

      public double getBalance()
      {
          return balance;
      }
    }