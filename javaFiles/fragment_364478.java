public class FINAL extends Applet implements Runnable
{
    Thread t;
    double a = 9.81;              // Play with the acceleration
    double h = 290.0;
    string currDirection = "down";  // Add current direction
    double timeMoving = 0.0;      // Time in each direction
    double speed = 0.0;           // Add speed
    double maxHeight = 290.0;          // Add first maxHeight

    // ...

    public void paint(Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;
        g.setColor(Color.BLUE);
        g.fillOval(100, h, 20, 20);

        //System.out.println("p = " +p);

        // time is 100ms = 0.1s
        timeMoving += 0.1;

        if (currDirection == "down")
        {
            h = 1/2*a*Math.pow(timeMoving,2);

            if((maxHeight-h) <= 0)
            {
                currDirection = "up";
                speed += -1 * a*(timeMoving);
                timeMoving = 0;
            }
        }
        else if (currDirection == "up")
        {
           h = speed*timeMoving + 1/2*a*Math.pow(timeMoving,2);
           double currentSpeed = speed + a*timeMoving; 

           if (currentSpeed >= 0)
           {
               maxHeight = h;
               currDirection = "down";
               speed = 0;
               timeMoving = 0;
           }
        }
    }
}