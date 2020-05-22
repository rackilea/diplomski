public class CPUPlayer {

    public int startX = 550;    // starting positions (x, y), always locked
    public int startY = 150;

    private int moveSpeed = 2;
    private boolean movingUp = true;
    public int score = 0;    // init

    public void move() {
        if(movingUp) {
            startY -= moveSpeed;
            if (startY <= -10)
                movingUp = false;    // switch directions
        } else {                     // Should be moving down
            startY += moveSpeed;
            if (startY >= 338)
                movingUp = true;    // switch directions
        }
    }

}