public class Ball {

    Ball() {
    }
    public int xPos = 25;
    public int yPos = 25;
    int diameter = 25;

    public void DrawSprite(Graphics2D g2) {
        g2.setColor(Color.BLACK);
        g2.fillOval(xPos - diameter / 2, yPos - diameter / 2, diameter, diameter);

    }

}