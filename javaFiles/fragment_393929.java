public class Game
{


    public Game()
    {
        Player player = new Player();

        System.out.println(player.getX()); // prints out 15 in the console
        System.out.println(player.getY()); // prints out 20 in the console

        Dot dot1 = new Dot();
        Dot dot2 = new Dot();
        Dot dot3 = new Dot();
    }
}