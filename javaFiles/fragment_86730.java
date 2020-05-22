public static void drawAll(Graphics g)
{
    g.drawString("Project 2 by NAMEHERE", 1,15);
}

public static void startGame(DrawingPanel panel, Graphics g) 
{
    //start startGame
    for (int i = 0; i <= 10000; i++) {
        panel.sleep(SLEEP_TIME);
        drawAll(g);
    }
} //end main game