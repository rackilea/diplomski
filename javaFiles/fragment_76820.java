import java.util.ArrayList;

public class Player {

protected int age;    //static is removed
protected String name;  // static is removed
protected static ArrayList<Player> players = new ArrayList<Player>();  //this is not a best practice to have a list of player inside player.

Player(String aName) {

    name = aName;
    age = 15;
    players.add(this); // i know this doesn't work but trying along these lines

   }


public static void main(String[] args) {
    // TODO code application logic here
    Player p1 = new Player("Peter");
}


}