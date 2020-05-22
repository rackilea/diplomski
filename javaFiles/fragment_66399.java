public static void main(String args[]){
   double price = Double.valueOf(args[0]);
   double salesTax = Double.valueOf(args[1]);
   String output = SalesTax(price,salesTax);
   System.out.println(output);
}