int menu = 0;
//you already said it: "the user can keep choosing something from 
//the menu until the user choses menu option 5"
while(menu != 5) {

    System.out.print("Enter the number of your choosing: ");
    menu = scan.nextInt();
    System.out.println();

    switch(menu){
        case 1: ...
        ...
        case 5: 
           break;
        default: System.out.println("Not supported.");
           break;
    }
}

//exit...