if (choice1 == 4){

       nbGamesEasy_Finished++;

       successRate_Easy = nbGamesEasy_Finished / nbGames_Easy * 100;

       System.out.println("How many time did you take to fill the grid ?");

       System.out.println("The time must be in minutes");

       String display5 = sudoku.nextLine();

       resolutionTime_easy = (nbGamesEasy_Finished * resolutionTime_easy) + Integer.parseInt(display5) / (nbGamesEasy_Finished);

}
else if (choice1 == 5){

       successRate_Easy = nbGamesEasy_Finished - 1 / nbGames_Easy * 100;

}
else {

       //default

}