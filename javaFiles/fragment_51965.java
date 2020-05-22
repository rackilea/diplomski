package taxreturn;


 import java.util.Scanner;   // on top


  public  class TaxReturn {
  // only one public class per file


  public static final int Single = 1;
  public static final int Married = 2;
  private static final double Rate1= 0.5;
  private static final double Rate2= 0.25;
  private static final double Rate3= 0.75;
  private static final double Single_Bracket1= 21450;
  private static final double Single_Bracket2= 51900;
  private static final double Married_Bracket1= 35000;
  private static final double Married_Bracket2= 86800;

  private double income;
  private int status;



public TaxReturn (double anIncome, int aStatus){
income=anIncome;
status = aStatus;
 }

  public double getTax (){
      double tax = 0;

if (status == Single ){
    if (income <= Single_Bracket1)

        tax = Rate1 * income;
        else if  ( income <= Single_Bracket2)
        tax = Rate1 * Single_Bracket1 + Rate2*(income - Single_Bracket1);
    else
        tax = Rate1 * Single_Bracket1 + Rate2 * (Single_Bracket2 -             Single_Bracket1) + Rate3 * (income - Single_Bracket2);
    }  // added

else

        if (income<= Married_Bracket1)
            tax=Rate1 * income;
        else if (income <= Married_Bracket2)
            tax= Rate1 * Married_Bracket1 + Rate2 * (income -
  Married_Bracket1);

        else
            tax = Rate1 * Married_Bracket1 + Rate2 * ( Married_Bracket2 -
  Married_Bracket1) + Rate3 * (income - Married_Bracket2);

    // not here  }

    return tax;
  } // ends getTax

 } // added, ends class


  // import java.util.Scanner; not here
   class taxReturnTester {

public static void main (String [] args) {
Scanner in = new Scanner (System.in);
System.out.print("Please Enter your Income:");
double income = in.nextDouble();
System.out.print("Please enter S (single) M (Married): ");
String input = in.next();

  // CHECK POINT

  System.out.println("Check point1");

  int status= 0;

  if (input.equalsIgnoreCase("s"))
      status= TaxReturn.Single;           // upcase
  else if (input.equalsIgnoreCase("m"))
      status = TaxReturn.Married;          // upcase
  else
  {  // added

System.out.println("Wrong Input. Please do it again");
  return;
  }  // added
   TaxReturn aTaxReturn = new TaxReturn(income,status);
    System.out.println ("The tax is: " + aTaxReturn.getTax() ); // added space
    }  // ends main
  }  // ends class

// not out any classes
// TaxReturn aTaxReturn = new TaxReturn(income,status);
// System.out.println ("The tax is" + aTaxReturn.getTax() );