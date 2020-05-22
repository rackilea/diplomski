private GLabel label;

public void run(){
    GOval ball = makeBall();
    label = new GLabel(String.valueOf(COUNTER), BALL_SIZE/2, BALL_SIZE/2);
    add(ball);
    add(label);
    bounce(ball);
}