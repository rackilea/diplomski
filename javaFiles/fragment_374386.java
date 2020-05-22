public void transfer(double amount, BankAccount recipient)
{
     if ( balance >= amount )
     {
        balance -= amount;
        //this balance variable represents the balance in the bank account 
        //object this money is coming from.
        recipient.balance += amount;
        //this balance variable is the balance of the recipient.
      }
}