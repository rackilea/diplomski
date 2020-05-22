public class myBall {

    int x;
    int y;
    int velX;
    int velY;


    public myBall(int x, int y, int velX, int velY) {
        this.x = (int )(Math.random() * 560);
        this.y = (int )(Math.random() * 360);
        this.velX = velX;
        this.velY = velY;
    }

    public void move() {
        x+=velX;
        y+=velY;

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void reverseX() {
        velX = -velX;
    }

    public void reverseY() {
        velY = -velY;
    }
}