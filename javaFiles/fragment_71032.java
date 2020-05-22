public class bankJava 
{

Scanner input = new Scanner(System.in);


double balance;

public void withdraw() 
{

    System.out.println("Enter amount: ");
    double amount = input.nextInt();

    balance = balance - amount;


}

public void deposit()
{

    System.out.println("Enter amount: ");
    double amount = input.nextInt();
    balance = balance + amount;

}