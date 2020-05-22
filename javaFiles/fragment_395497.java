public class Player extends Character
{
    public Player()
    {
        cc = rand.nextInt(20)+51;
        strength = rand.nextInt(3)+4;
        life = rand.nextInt(5)+16;
    }
}