public class UnfairCandyDistributor {

    private int you = 0;
    private int me = 0;
    private boolean candyToMe = false;

    public void nextCandy()
    {
        if (candyToMe)
        {
            for (int i=0; i<you; i++) {
                 System.out.println("one for me");
                 me++;
        }
        else
        {
                 System.out.println("one for you");
                 you++;
        }
        candyToMe = !candyToMe;
    } 
}