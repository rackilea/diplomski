public void deposit()
{
   Scanner input = new Scanner(System.in);
   System.out.printn("Enter deposit amount: );
   double amount = input.nextDouble();
   System.out.println("Your deposit amount: " + amount);
   currentBalance += amount;
   System.out.println("Your new balance is: + currentBalance);
}

public void withdrawal()
{
   Scanner input = new Scanner(System.in);
   System.out.printn("Enter withdrawal amount: );
   double amount = input.nextDouble();
   System.out.println("Your withdrawal amount: " + amount);
   currentBalance -= amount;
   System.out.println("Your new balance is: + currentBalance);
}