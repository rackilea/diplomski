Scanner scanner = new Scanner(System.in);

double price_per_liter = 0.38;

System.out.print("Enter amount of milk to buy: "); 
double milk_amount = scanner.nextdDouble(); //ask for user input

double cartonsNeeded = milk_amount / price_per_liter ;

double total  =  milk_amount * price_per_liter ; // reused the milk_amount variable

System.out.println("Total amount: "+ total
                   + "Cartons needed: "+ cartonsNeeded);