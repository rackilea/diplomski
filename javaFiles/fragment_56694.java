player.java:
public class Player 
{
    public static void main(String[] args) {
        Player player = new Player();
        Monster monster = new Monster();
        monster.attackPlayer(player);
    }
    public int getLocation()
    {
         return 2;
    }
}

monster.java:
public class Monster
{
    public void attackPlayer(Player player)
    {
        player.getLocation();
    }
}