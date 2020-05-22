public static void main(String[] args) 
{
   // Create an instance of the SalesCommission class (an object)
   SalesCommission salesCommission = new SalesCommission();

   //Scanner input
   Scanner input = new Scanner( System.in );
   int totalSales;
   int salesPlusSalary;

   //input commissions        
   System.out.print( "Enter Annual Commissions" );
   totalSales = input.nextInt();

   salesPlusSalary = (int) (totalSales * .05 + SalesCommission.baseSalary);

   System.out.printf( "Sales commission plus Salary is %d\n", salesPlusSalary );  
}