import java.awt.Point;
public class  Path
{
    public static void main(String[] args) 
    {
        Point start         = new Point(0,0);
        Point destination   = new Point(100,150);
        int   iStages = 9;//Suppose I want to reach to destination in 9 jumps
        int   jumpX = (destination.x - start.x) / iStages;
        int   jumpY = (destination.y - start.y) / iStages;
        Point currPos = start;
        for (int i = 0; i < iStages ; i++)
        {
            System.out.println(currPos);
            currPos = new Point(currPos.x + jumpX , currPos.y + jumpY );
        }
        currPos = new Point(destination.x , destination.y);
        System.out.println(currPos);
    }
}