public class StartingPoint extends Applet {

    public int startX, startY;
    private static final int nbBalles = 10;
    private static final long serialVersionUID = 1L;
    ArrayList<Ball> BallList = new ArrayList<Ball>();
    ...

    @Override
    public void paint(Graphics g)
    {
         for(Ball ball : BallList)
         {
             ball.paint(g);
         }
    }
}