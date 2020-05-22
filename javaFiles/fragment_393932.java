public class Game
{
    public Game()
    {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        int j = sc.nextInt();

        Player player = new Player(i,j);

        player.setX(35);
        player.setY(48);
    }
}