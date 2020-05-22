private static char getHighLow(Scanner inScanner) {
    System.out.print("High, low or sevens (H/L/S):");
    String entered = inScanner.nextLine();
    System.out.print(entered);
    if(entered.equals("H") || entered.equals("h")){
        return 'h';
    }
    else if (entered.equals("L") || entered.equals("l")){
        return 'l';
    }
    else if(entered.equals("S") || entered.equals("s")){
        return 's';
    }
    else {
        System.out.println("Invalid entry. Please try again using H/L/S!");
        return getHighLow(inScanner);
    }   
}