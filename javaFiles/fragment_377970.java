public class UnfairCandyDistributor {

    private int you = 0;
    private int me = 0;
    private boolean candyToMe = false;

    public void nextCandy()
    {
        if (candyToMe)
        {
                 System.out.println(you + " for me");
                 me += you;
        }
        else
        {
                 System.out.println("1 for you");
                 you++;
        }
        candyToMe = !candyToMe;
    } 
}