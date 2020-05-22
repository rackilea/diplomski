public static int ComputerPlays(int matches){ //Method for the computers turn
    int matchesTaken = 0;

    if (matches > 7){ matchesTaken = new Random().nextInt(3)+1; }
    else if (matches > 4 && matches < 8){ matchesTaken = matches - 4; }
    else if (matches == 1){ matchesTaken = 1; }
    else if (matches < 5){ matchesTaken = matches - 1; }

    System.out.println("Computer takes " + matchesTaken + " matches");
    return(matches - matchesTaken);
}