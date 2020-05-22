class BankAccount {
   Scanner input = new Scanner(System.in);
   static String name, actype;
   static int bal, amt;
   Random randomGenerator = new Random();
   int accNo = randomGenerator.nextInt(100);
   Money money;

   BankAccount(String name, int accNo, String actype, int bal) {
    this.name = name;
    this.accNo = accNo;
    this.actype = actype;
    this.bal = bal;
    this.money = new Money();
  }

  public Money getMoney(){
     return this.money;
  }
  .....
}