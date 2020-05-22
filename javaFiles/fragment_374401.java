while(input.hasNextInt()) {
    int cijfer = input.nextInt();
    if(cijfer < 0 || cijfer > 100) {
        System.out.println("Please enter a number between 1 and 100.");
    } else {
        myClassroom.add(cijfer);
        counter++;
    }

    if(counter == 21 || counter == 31 || counter == 41 || counter == 51 || counter == 61) {
        System.out.println("Enter the " + counter + "st" + " number");
    } else if(counter == 2 ||counter == 22 ||counter == 32 ||counter == 42 ||counter == 52 ||counter == 62) {
        System.out.println("Enter the " + counter + "nd" + " number");
    } else if(counter == 3 ||counter == 23 ||counter == 33 ||counter == 43 ||counter == 53 ||counter == 63){
        System.out.println("Enter the " + counter + "rd" + " number");
    } else if(counter == 1) {
        System.out.print("");
    } else {
        System.out.println("Enter the " + counter + "th" + " number");
    }
}