import java.util.Scanner;

class Person{
private String name;
private String address;
private String number;
private int customerPurchase = 0;

//Constructors
public Person(String name, String address, String number, int customerPurchase){
  this.name = name;
  this.address = address;
  this.number = number;
  this.customerPurchase = customerPurchase;
}

public Person(){}

//Accessors
public String getName(){
  return this.name;
}

public String getAddress(){
  return this.address;
}

public String getNumber(){
  return this.number;
}

public int getcustomerPurchase(){
  return this.customerPurchase;
}

//Mutators
public void setName(String n){
  this.name = n;
}

public void setAddress(String a){
  this.address = a;
}

public void setNumber(String n){
  this.number = n;
}

public void setcustomerPurchase(int a){
  this.customerPurchase = a;
}
public void setcustomerDiscount(int r)
{

}

}
///////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////
class Customer extends Person{
private String customerNumber;
private boolean recieveMail;
private String customerDiscount;

//Constructors
public Customer(String name, String address, String number, String customerN, boolean rm, int customerPurchase) {
  super(name, address, number, customerPurchase);
  this.customerNumber = customerN;
  this.recieveMail = rm;
}

public Customer(){}

//Accessors
public String getCustomerNumber(){
  return this.customerNumber;
}

public boolean getRecieveMail(){
  return this.recieveMail;
}
public String getcustomerDiscount()
{
  return customerDiscount;
}

//Mutators
public void setCustomerNumber(String c){
  this.customerNumber = c;
}

public void setRecieveMail(boolean r){
  this.recieveMail = r;
}

public void setcustomerDiscount(int r)
{
  String customerDiscount = "";

  if (r >= 2000)
  {
    customerDiscount="10%";
      System.out.print("10%");
  }
  else if (r >= 1500)
  {
    customerDiscount="7%";
      System.out.print("7%");
  }
  else if (r >= 1000)
  {
   customerDiscount="6%";
      System.out.print("6%");
  }
  else if (r > 500)
  {
    customerDiscount="5%";
      System.out.print("5%");
  }
  else
  {

      System.out.print("");
  }
  this.customerDiscount = customerDiscount;
}
}

public class TestMain
{

public static void main(String args[]){

  Scanner scanner = new Scanner(System.in);

  System.out.print("Enter name of customer:");
  String name1 = scanner.nextLine();
  System.out.print("Enter address of customer:");
  String address1 = scanner.nextLine();
  System.out.print("Enter phone number of customer:");
  String number1 = scanner.nextLine();
  System.out.print("Enter customer number:");
  String customerNumber = scanner.nextLine();
  System.out.print("Enter yes/no -- does the customer want to recieve mail?:");
  String answer = scanner.nextLine();
  boolean recieveMail = (answer.equals("yes"));
  System.out.print("Enter amount customer has spent:");
  int customerPurchase = scanner.nextInt();
  scanner.close();

  Customer customer = new Customer(name1, address1, number1, customerNumber, recieveMail, customerPurchase);

  System.out.println("\nCustomer: ");
  System.out.println("Name: "+customer.getName());
  System.out.println("Address: "+customer.getAddress());
  System.out.println("Phone Number: "+customer.getNumber());
  System.out.println("Customer Number: "+customer.getCustomerNumber());
  System.out.println("Recieve Mail?: "+customer.getRecieveMail());
  System.out.println("Amount Purchased: "+customer.getcustomerPurchase());
  customer.setcustomerDiscount(customerPurchase);
  System.out.println("Percent off:  "+ customer.getcustomerDiscount());


}
}