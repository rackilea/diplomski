public static void main(String[] args)
{
System.out.println("Welcome to the loan calculator"); //welcome user to loan calculator
Scanner sc = new Scanner(System.in); // create new scanner
//String choice = "y"; //start choice loop [no need for that line anymore]
boolean quit = false; 
do{
        System.out.println();
        System.out.println("DATA ENTRY");
        double loanAmount = getDoubleWithinRange(sc, "Enter loan amount: ", 
                0.0, 1000000.0); //get user input for loanAmount
        //get user input for interestRate
        double interestRate = getDoubleWithinRange(sc, 
                "Enter yearly interest rate: ", 0, 20); 
        //get user input for years
        int years = getIntWithinRange(sc, "Enter number of years: ", 0, 100); 
        int months = years * 12; // calculate years to months
        //calculate monthly payment
        double monthlyPayment = loanAmount * interestRate/
                (1 - 1/Math.pow(1 + interestRate, months)); 
        //import currency instance
        NumberFormat currency = NumberFormat.getCurrencyInstance(); 
        // import percent instance
        NumberFormat percent = NumberFormat.getPercentInstance(); 
        percent.setMinimumFractionDigits(1); //set fraction digits for percent 
        System.out.println("RESULST"); //print results 
        //print loanAmount
        System.out.println("Loan Amount: " + currency.format(loanAmount)); 
        //print interestRate
        System.out.println("Yearly interest rate: " + percent.format(interestRate)); 
        System.out.println("Number of years: " + years); //print years
         //print monthlyPayment
        System.out.println("Monthly payment: " + currency.format(monthlyPayment)); 


        // then after all your program stuff
        boolean choiceIsOK = false;
            do{

                System.out.println();
                System.out.println("Continue? (y/n): "); //prompt user to continue 
                String userinput1 = sc.next();
                    char choice1 = userinput1.toLowerCase().charAt(0);
                    switch(choice1){
                    case 'y':
                        // case y, do nothing, you could even remove that case.
                        choiceIsOK = true;
                        break;
                    case 'n':
                        // case n, do something here
                        choiceIsOK = true; // I fixed this
                        quit = true;
                        break;
                    default:
                        // error or warning
                        System.out.println("Type Y or N to respectively continue or quit");
                        break;
                    }
                }while(!choiceIsOK);

    }while(!quit);

    }           
}