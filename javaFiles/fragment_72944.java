public class Driver {

    public static void main(String[] args) {

        Scanner myKey = new Scanner(System.in);

        System.out.print("Please enter the number of players (2-5): ");
        int numPlayers = myKey.nextInt();

        //  Player joueur[]= new Player[numPlayers]; // Initializing the Player Objects
        String playerNames[] = new String[numPlayers];  // String Array to store Player Names

        for (int i = 0; i < numPlayers; i++) {
            System.out.print("Please enter the name of player" + i + ": ");
            String name = myKey.next();

            //      joueur[i].name = name;          // Do you really need Player objects to do some other tasks? if yes uncomment this.
            playerNames[i] = name;
        }
        Qwixx qwixx = new Qwixx(playerNames);

        String testNames[] = qwixx.getPlayerNames();

        for (String test : testNames) {
            System.out.println(test);
        }
        // Some other code
    }
}

      class Qwixx {

         private String[] Players;

        public Qwixx() {

    }
//constructor

    public Qwixx(String[] Players) {

        this.Players = new String[Players.length];
        //  System.arraycopy(Players, 0, this.Players, 0, Players.length); 
   // You can use this method System.arraycopy instead of the below for loop.   

        for (int i = 0; i < Players.length; i++) {
            this.Players[i] = Players[i];
        }
    }

    public String[] getPlayerNames() {
        return this.Players;
    }
}