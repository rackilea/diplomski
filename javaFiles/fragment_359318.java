double price = 0.0;
do {
    System.out.println("What would you like to add to your plan (options are a,b,c, or d. Enter -1 when you are finished):  ");
    yourChoice = scanner.nextLine();
    switch (yourChoice) {
        case "a":
            price += Double.parseDouble(plans[0].substring(plans[0].length()-4, plans[0].length()));
            break;
        case "b":
            price += Double.parseDouble(plans[1].substring(plans[1].length()-4, plans[1].length()));
            break;
        case "c":
            price += Double.parseDouble(plans[2].substring(plans[2].length()-4, plans[2].length()));
            break;
        case "d":
            price += Double.parseDouble(plans[3].substring(plans[3].length()-5, plans[3].length()));
            break;
    }
} while (!yourChoice.equals(SENTINEL));

System.out.println("Total price: " + price);