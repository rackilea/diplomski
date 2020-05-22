double A=0;
do {   
    System.out.println("Set the A param: ");
    if(input.hasNextDouble() == true) { //check for valid value 
        A = input.nextDouble();
        if(A == 0) {
            System.out.println("Param A cannot be a 0!");
        }
    } else{ // no valid value found , print msg and jump over the previous input
        input.nextLine();
        System.out.println("Param A must be a number!");
    }
} while(A == 0); // just check , if the desired value is received 
                 // previously input.hasNextDouble() had no use cuz we already              
                 // checked no double value found so will be false, don't use it