public static void lebronJames() {
                // TODO Auto-generated method stub
                 Scanner input = new Scanner(System.in);
               While(true){ // keeps it in a loop forever and only a "break" statement can stop it

                 //Declare an array to hold 8 intgers values
                 int lebronJamesAttributes[] = new int[8];
                 int attribute = 0;
                 System.out.println("Please allocate your attribute points for Lebron James in the following order. Your point allocations per attribute should be between 1 and 10. You have a total of 60 points to allocate");
                 System.out.println("-----------------");
                 System.out.println("Close Range" + "\n" + "Mid Range" + "\n" + "Three Point" + "\n" + "Free Throw" + "\n" + "Offensive Rebound" + "\n" + "Defensive Rebound" + "\n" + "Assist" + "\n" + "Steal" + "\n");        

                 while (attribute <= 7) {
                     int attributeValue = input.nextInt();
                     if (attributeValue >= 1 && attributeValue <= 10 ) {
                         lebronJamesAttributes[attribute] = attributeValue;
                         attribute++;
                     } 
                     else {
                         System.out.println("The attribute value you have selected is out of range. Select again.");
                     }  
                 }              
                 int jamesTotalQuarter = 0;
                 for (int jamesTotalQ1 : lebronJamesAttributes){
                      jamesTotalQuarter += jamesTotalQ1;
                 }


                 if (jamesTotalQuarter != 60) {
                      System.out.println("You have entered the wrong total number of attribute points. Please enter a total of 60 attribute points between the 8 characteristics.");
                      System.out.println("You have allocated a total of " + jamesTotalQuarter + " points.");
                     continue;     // loop execution starts from the beginning and your program gets fresh inputs.       
    }
                 else {
                                System.out.println("Close Range" + lebronJamesAttributes[0] + "\n" + "Mid Range" + lebronJamesAttributes[1] + "\n" + "Three Point" + lebronJamesAttributes[2] + "\n" + "Free Throw" + lebronJamesAttributes[3] + "\n" + "Offensive Rebound" + lebronJamesAttributes[4] + "\n" + "Defensive Rebound" + lebronJamesAttributes[5] + "\n" + "Assist" + lebronJamesAttributes[6] + "\n" + "Steal" + lebronJamesAttributes[7] + "\n");         
                                System.out.println("You have allocated a total of " + jamesTotalQuarter + " points.");}
                                break; // breaks from the loop on correct input

                            }

                       }

            }