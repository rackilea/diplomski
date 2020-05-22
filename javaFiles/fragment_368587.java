public class Game
{
    Player p1, p2;
    public Game(String p1Name, String p2Name)
    {
        p1 = new Player(p1Name);
        p2 = new Player(p2Name);
        System.out.println(p1Name + " vs. " + p2Name);
    }
}