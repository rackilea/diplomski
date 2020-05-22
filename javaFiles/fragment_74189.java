//declare the variables outside the loop
int largest = 0;
String popularBird = "";
Scanner scanner = new Scanner(System.in);//use the same scanner

try{
    while (true) {
      System.out.println("Which bird have you seen?");
      String answerBird = scanner.nextLine();

     if (answerBird.equalsIgnoreCase("end")) {
                  System.out.println("You saw " + largest + " " + popularBird);
                   System.out.println("It was the most 
                         common bird seen at one time in your garden.");
                       break;
      }//end if statement

     System.out.println("How many were in your graden at once?");            
     int answerNumber = Integer.parseInt(scanner.nextLine());

     if(largest < answerNumber) {
                        largest = answerNumber;
                        popularBird  = answerBird;
              }
            }
     } finally {
            if(scanner != null)
               scanner.close();//close the scanner
         }
     }