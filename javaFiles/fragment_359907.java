Room arr=new Room[100];
 int count=0;
     while (repeat)
        {   


    System.out.println("\n" +"What is the length of the room?: ");
    length = keyboard.nextInt();

    System.out.println("What is the width of the room?: ");
    width = keyboard.nextInt();

    System.out.println("What is the price of the carpet per square yard?:      ");
    price_per_sqyd = keyboard.nextDouble();

        System.out.println("What is the price for the padding?: ");
        price_for_padding = keyboard.nextDouble();

    System.out.println("What is the price of the installation?: ");
    price_for_installation = keyboard.nextDouble();


        keyboard.nextLine();

        System.out.println( "\n" + "Type 'yes' or 'no' if this is correct: ");
    input = keyboard.nextLine();
arr[count]=new Room(length,width,price1,price2,price3,price4);//call to the constructor
    if ("yes".equals(input)) 
     repeat = true; 
count++;
    else 
     repeat = false; 

    } 
}