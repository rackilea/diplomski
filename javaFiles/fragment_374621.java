public IAccount getAccount()
 {
     IAccount account;
     account = null;
     try
        {
         //Notice fully qualified name is used.
         account = (IAccount)Class.forName("org.mydomain.SavingAccount").newInstance();
         account.Deposit(500);
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        } 
     return account;
}