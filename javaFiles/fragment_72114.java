import java.util.Scanner;


public class Taxable {
    private final static double first15 =0.1;   
    private final static double next20  =0.2;
    private final static double over35  =0.25;
    private final static double tax_inc =0.8;

    private double sal;

    private double taxInc;
    private double tax = 0;
    private double avgtax;
    public static void main(String[] args) {
        System.out.printf("Enter Salary: ");
        Scanner in = new Scanner(System.in);

        Taxable taxable = new Taxable();
        taxable.setSal(in.nextDouble());
        System.out.println(taxable.calculateTax());
    }
    private String calculateTax(){  
        setTaxInc(getSal()*tax_inc);

        if (getTaxInc() > 0 && getTaxInc() <= 15000){
            setTax(getTaxInc()*first15);
        }
        else if (getTaxInc() > 15000 && getTaxInc() <= 35000){
            setTax((15000 * first15) + ((getTax() - 15000) * next20));
        }
        else if (getTaxInc() > 35000){
            setTax((15000 * first15) + (20000 * next20) + ((getTax() - 35000) * over35)) ;
        }
        else {
            System.out.printf("\nInvalid Salary Figure.");
        }
        setAvgtax((getTax()/getSal())*100);
        String calculation = "\n At a salary of: " + getSal() + "\n Tax to be paid is: " + getTax() + "\n Average Tax Rate is: " + getAvgtax(); 
        return calculation;     
    }
    public double getSal() {
        return sal;
    }
    public void setSal(double sal) {
        this.sal = sal;
    }
    public double getTaxInc() {
        return taxInc;
    }
    public void setTaxInc(double taxInc) {
        this.taxInc = taxInc;
    }
    public double getTax() {
        return tax;
    }
    public void setTax(double tax) {
        this.tax = tax;
    }
    public double getAvgtax() {
        return avgtax;
    }
    public void setAvgtax(double avgtax) {
        this.avgtax = avgtax;
    }
}