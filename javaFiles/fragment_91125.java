String input = "";                       //just for receiving inputs

do{
    System.out.println("Input Cruise ID:");
    input = sc.nextInt();
}while(!input.matches("[0-9]+"));        //repeat if input does not contain only numbers

int cruiseID = Integer.parseInt(input);  //actual curiseID in integer