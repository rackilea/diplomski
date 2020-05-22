public class Player
{
    public Integer points;

    public Player(){
        points=0;
    }

    public static void main(String[] args)
    {
        CardGames game = new CardGames();
        Player steve = new Player();
        System.out.println(game.playSimpleCardGame("red", steve));
        System.out.println(game.playSimpleCardGame("red", steve));
        System.out.println(game.playSimpleCardGame("black", steve));
        System.out.println(game.playSimpleCardGame("black", steve));
        System.out.println(steve.points);
    }
}

public class CardGames
{
    /*
     * Rules of this game: 
     * If you draw a red card, you get a point.  
     * If you draw a black card, you lose two points.
     */
    public int playSimpleCardGame(String color, Player player)
    {
        if (color.equalsIgnoreCase("red"))
            return player.points = player.points + 1;
        else 
            return player.points = player.points - 2;
    }
}