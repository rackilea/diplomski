void setData() {
    //let's get the name
    System.out.print("What's your name: ");
    name = console.nextLine();

    System.out.print("Are you coding an app or a game? ");

    //since we want the user to enter 'app' or 'game'
    //we need to loop until we got these
    //we can do this by creating endless while loop,
    //which we will end when we have correct input
    while (true) {
        workType = console.next();

        if (workType.equals("app")) {
            pay = 20.0;

            //stop the loop
            break;
        }
        else if (workType.equals("game")) {
            pay = 30.0;

            //stop the loop
            break;
        }
        else {
            System.out.print("Please enter either 'app' or 'game': ");
            //back to top
        }
    }

    //ok, we're out the loop, let's get number of hours
    System.out.print("Please enter how many hours you have worked this week: ");
    hrsWorked = console.nextInt();

    //calculate weekPay
    weekPay = hrsWorked * pay;

    if(weekPay >= 865) {
        tax = 0.4;
    }
    else {
        tax = 0.21;
    }

    //calculate pay after tax
    weekPayAfterTax = weekPay - weekPay * tax;
}