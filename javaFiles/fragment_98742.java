public class Coin
{
private String sideUp;

public void toss()
{
    Random flip = new Random();
    if (flip.nextInt(2) == 0)
    {
        sideUp = "Tails";
    }
    else
    {
        sideUp = "Heads";
    }
}

public String getSideUp()
{
    return sideUp;
}
}