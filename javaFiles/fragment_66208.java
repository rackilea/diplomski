public InputMenu() 
{
    Scanner in = new Scanner(System.in);
     display_menu();

    do{       //here
        int input = in.nextInt();
        switch (input) 
        {
            case 1:
            System.out.println ( "You picked option 1" );
            question();
            break;

            case 2:
            System.out.println ( "You picked option 2" );
            question();
            break;

            case 3:
            System.out.println ( "You picked option 3" );
            question();
            break;
            default:
            System.err.println ( "Unrecognized option" );
                reenter();
       }
    }
    while(input>3 || input <1); //here

}