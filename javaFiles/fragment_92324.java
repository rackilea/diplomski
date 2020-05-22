int myno;
Scanner scanner  =new Scanner(System.in);
boolean exit = false;
while(!exit){

    System.out.println("1. Menu 1");//Modify your menu
    System.out.println("2. Menu 2");
    System.out.println("3. Menu 3");
    System.out.println("4. Menu 4");
    System.out.println("5. Menu 5");
    System.out.println("6. Menu 6");

    myno = scanner.nextInt();

    switch(myno){
    case 1 :
        //do something
        break;
    case 2 :
        //do something
        break;
    case 3 :
        //do something
        break;                     //add for remaining cases
    case 7 :
        exit = true;//for exit
        break;  

    default :
        // do something   //set exit = true if you what to end the program for other inputs
    }
}