boolean quit = false;
do{ // change your while by this

    // your own stuff here


    // then after all your program stuff
    boolean choiceIsOK = false;
    do{
    String userinput = sc.next();
    char choice = userinput.toLowerCase().charAt(0);
    switch(choice){
    case 'y':
        // case y, do nothing, you could even remove that case.
        choiceIsOK = true;
        break;
    case 'n':
        // case n, do something here
        choiceIsOK = false;
        quit = true;
        break;
    default:
        // error or warning
        System.out.println("Type Y or N to respectively continue or quit");
        break;
    }
    }while(!choiceIsOK);
}while (!quit);