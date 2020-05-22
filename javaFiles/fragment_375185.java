public class testBank
{  
    private creditAccount a1;
    private creditAccount a2;
    private creditAccount a3;
    private currentAccount b1;
    private currentAccount b2;
    private currentAccount b3;
    private depositAccount c1;
    private depositAccount c2;          
    private depositAccount c3;      
    private savingsAccount d1;
    private savingsAccount d2;
    private savingsAccount d3;

    public testBank()
        //Create an array of objects.//
    {
        this.a1 = new creditAccount("Mary Chapple", 2400.41);
        this.a2 = new creditAccount("Jim Smith", 2.56);
        this.a3 = new creditAccount("Henry A Jones", 700.89);
        this.b1 = new currentAccount("Simon Hopkins", 86.01);
        this.b2 = new currentAccount("Jack C Whitheridge", 40000.29);
        this.b3 = new currentAccount("Bill Sutton", 100.23);
        this.c1 = new depositAccount("Theo Gibson", 145.99);
        this.c2 = new depositAccount("Jasper Williams", 3000.29);          
        this.c3 = new depositAccount("Julie Banks", 1000001.99);      
        this.d1 = new savingsAccount("Burnard White", 2400.42);
        this.d2 = new savingsAccount("Richard Bennett", 203.16);
        this.d3 = new savingsAccount("Bob Robinson", 10000.11);
        bankAccount[]theAccounts = {a1,a2,a3,b1,b2,b3,c1,c2,c3,d1,d2,d3};

        showAccounts (theAccounts);
    }

    private void showAccounts(bankAccount[] aa)
    { 
        for (int i = 0;i <aa.length;i++)  
        {
         System.out.println("Account Holder: " +aa[i].getAccountName());
         System.out.println("Balance = £" +aa[i].getBalance());
         System.out.println("Balance pluss APR = £" +aa[i].calculateInterest());
        }
    }

    public static void main(String[]args)
    {

        testBank z1 = new testBank();
    }
}