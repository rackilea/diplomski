public class Match {
      public static int factorial(int num) {
          int i = 1 ;
          while(num != 1) {
              i = i * num ;
              num-- ;
          }
          return i ;
      }
      public static int search(int[] array) {
          int var ;
          for(var = 0 ; var < array.length ; var++ ) {
             if(array[var] == 0) {
              return var ;
             }
          }
          return -1 ;
      }
      public static void main(String [] args) {
            String[] teams = new String[4];
            teams[0] = "BOSTON";
            teams[1] = "CLEVELAND";
            teams[2] = "SPURS";
            teams[3] = "WARRIORS";
            int [] opp = new int[4] ; // array that determines if a team has got an opposition team
            int comb = (factorial(teams.length)) / (2 * factorial(teams.length - 2)) ; //find no.of possible combinations
            int match = comb / (teams.length/2) ; // find number of matches
            for(int i = 0 ; i < opp.length ; i++) { //clear array
                opp[i] = 0 ;
            }
            System.out.println("Number of teams:" + teams.length);
            System.out.print("[ ");
            for (String team : teams) {
                System.out.print(team + " ");
            }
            System.out.print("]\n");
                for (int j = 1 ; j <= match ; j++) {
                   System.out.format("\n--- Match %02d---\n", j);
                   System.out.println(teams[0] + " - " + teams[j]); //set the first team and its opponent
                   opp[0] = 1 ; // first team has been set 
                   opp[j] = 1 ; // opponent has been set
                   for(int i = 2 ; i <= teams.length/2 ; i++) { //first pair has been set, start from second pair
                       int var1 = search(opp); // look for next team without opponent
                       opp[var1] = 1 ;
                       int var2 = search(opp); // look for next team without opponent
                       opp[var2] = 1 ;
                      System.out.println(teams[var1] + " - " + teams[var2]);
                   }
                   for(int i = 0 ; i < opp.length ; i++) { //clear the array
                        opp[i] = 0 ;
                    }
                }

      }
}