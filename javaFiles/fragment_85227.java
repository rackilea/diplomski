int i = 0;
    Scanner input = new Scanner(System.in);
    while (i == 0) {
        System.out.println("Enter number zero plz");
        int result = input.nextInt();
        if(result == 0 ){
            System.out.println("I entered right number");
            i = 1;
        } else
            System.out.println("you entered the wrong number \nplz try again");
    }