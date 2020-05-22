import java.util.Scanner;
       public class jakeGrim {
       public static void main(String[] args) {
       int option;
       String squareFootage="";
       int noBed = 0;
       double totalSum =0;
       String propertyCode="";
       String propertyType="";
       String threshold="";
       Scanner input = new Scanner( System.in );
       Scanner user_input = new Scanner( System.in );
       double[] array = new double[12]; 
       do{
        // Display menu graphics
        System.out.println(" ");
        System.out.println("|  *****Rental Menu*******   |");
        System.out.println("|        1. Enter rental property Details     ");
        System.out.println("|        2. Enter monthly rent ( 12 Months )       ");
        System.out.println("|        3. Display Annual Rent");
        System.out.println("|        4. Display rental report       ");
        System.out.println("|        5. Display Monthly rents falling below a certain threshold       ");
        System.out.println(" ");
        System.out.println(" Please Select an option: ");
        option = input.nextInt();

          switch (option){
        case 1:
        System.out.println("Enter Rental Details: ");
        System.out.println("Property Code:            ");
        propertyCode = user_input.next();
        System.out.println("Property Type:            ");
        propertyType = user_input.next();
        System.out.println("Square Footage:           ");
        squareFootage = user_input.next();
        System.out.println("Number Of bedrooms        ");
        noBed = input.nextInt();
        break;

        case 2:

        Scanner keyboardScanner = new Scanner(System.in); 
        for (int i = 0; i < 12; i++) {
        System.out.println("Enter Rental for month[" +( i +1)+ "]");
        array[i] = keyboardScanner.nextDouble();
         }
       //So now, we need to do something with that array and sum up all the values in that array. 
        for (int i = 0; i < array.length; i++){
         System.out.println(array[i]);
        totalSum += array[i];
        }
        break;

        case 3:
        System.out.println("The annual rent for propery code "+propertyCode+" is:  " +totalSum);
        break;

        case 4:
        System.out.println(" Property Code:      "+propertyCode);
        System.out.println(" Property Type:      "+propertyType);
        System.out.println(" Square Footage:     "+squareFootage);
        System.out.println(" Number of Bedrooms: "+noBed);
        System.out.println("");
        System.out.println("");
        for(int i = 0; i<12; i++)
        System.out.println("Rental for month " + (i+1) + " : " + array[i]);
        break;

        case 5:
        //    Scanner user_input = new Scanner( System.in );
        System.out.println("Enter the Rental Threshold: ");
        threshold = user_input.next();
        for(int i=0;i<array.length;i++){
        if(Integer.valueOf(threshold)>array[i])
        System.out.println("Month "+(i+1)+" has the rent falling below the threshold range as the rent is "+array[i]);
        }
        System.out.println("");
        break;

        default:
        System.out.println("Invalid selection");
        break; 

       }
       } while (option>=1 && option<=5);
     }
    }