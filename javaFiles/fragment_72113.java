public class Taxable {
    final static double first15=0.1;

    final static double next20=0.2;
    final static double over35=0.25;
    final static double tax_inc=0.8;
    public static void main(String[] args) {
        double sal;
        double taxInc;
        double tax = 0;
        double avgtax;
        Scanner in = new Scanner(System.in);
        System.out.printf("Enter Salary: ");
        sal = in.nextDouble();
        taxInc = sal*tax_inc;
        if (taxInc > 0 && taxInc <= 15000) tax = taxInc*first15;
        else if (taxInc > 15000 && taxInc <= 35000) tax = (15000 * first15) + ((taxInc - 15000) * next20);
        else if (taxInc > 35000) tax = (15000 * first15) + (20000 * next20) + ((taxInc - 35000) * over35);
        else System.out.printf("\nInvalid Salary Figure.");
        avgtax = (tax/sal)*100;
        System.out.printf("\nAt a salary of: %3.2f\nTax to be paid is: %3.2f\nAverage Tax Rate is: %3.1f", sal, tax, avgtax);
    }
}