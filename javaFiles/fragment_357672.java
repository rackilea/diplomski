int totalGames = 0; // could be nextLine
int totalScore = 0;
int totalPlayed = 0;
for (int index = 0; index < nextLine; index++) {

    System.out.println("Game: " + game[index] + " | " + "Total Score: " + score[index] + " | " + "Minutes played: " + min[index]);
    totalGames++;
    totalScore += score[index];
    totalPlayed += min[index];

}

System.out.println("");
System.out.println("");
System.out.println("Players name: " + name);
System.out.println("-------------------------------");
System.out.println("Total games: " + totalGames);
System.out.println("Overall score: " + totalScore);
System.out.println("Total minutes played: " + totalPlayed);