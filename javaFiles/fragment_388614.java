public class BankAccount
    {
        private boolean isLocked = false;
        private int balance;
        private String name;
        private int nrWithdrawals;
        public  Transaction Transaction;
        private ReentrantLock lock = new ReentrantLock();

        public BankAccount()
        {
            this.balance = 300;
            this.name = "Bank Account";
        }

        public synchronized void Withdraw(Transaction tran)
        {
            lock.lock();
            while(!CanWithdraw(tran))
            {
                try
                {
                    lock.unlock();
                    System.out.println("Not enough money. Waiting for manager to deposit");
                    wait();
                    lock.lock();

                }
                catch( InterruptedException e) {}
            }
            this.setBalance((this.getBalance() - tran.getBalance()));
            notifyAll();

            System.out.println("Remaining Balance is: " + this.getBalance());
            lock.unlock();
        }


        public synchronized void depositMoney( )
        {
            lock.lock();
            while(this.getBalance() + 100 <= this.BankAccountLimit)
            {
                try
                {
                    lock.unlock();
                    wait();
                    lock.lock();
                }
                catch(InterruptedException e){}
            }


            this.setBalance(this.getBalance() + 100);
            notifyAll();
            System.out.println("Bank Account balance is: " + this.getBalance());
            lock.unlock();
        }
    }