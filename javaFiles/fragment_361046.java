int sum = 0;
int integer = 0;
String addPrice = "Y";
while( "Y".equalsIgnoreCase(addPrice) ) {
   System.out.println("Please enter a price: ");
   integer = input.next();
   sum += integer ;
   count++;        
   System.out.println("Enter another price? ");
   addPrice = input.next();
}
int avg = sum / count ;