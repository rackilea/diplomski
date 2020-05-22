for (int i = 2; i < die.length; i++) {
     numAsterisks = 100 * die[i] / numGames;
     System.out.print(i + ": "); //Changed println to print
     for (int x = 0; x < numAsterisks; x++) {
         System.out.print("*");
     }
     System.out.println(); //Added println
 }