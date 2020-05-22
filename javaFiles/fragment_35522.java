package codeSamples_II;

import acm.program.*;
import acm.graphics.*;


public class PlayBall extends GraphicsProgram {

private static final int DELAY = 50;
private GOval ball;
private static final int BALL_RADIUS = 10;

public void run() {
    setup();
    play();
}

private void setup() {
    ball = new GOval(0,0, BALL_RADIUS*2, BALL_RADIUS*2);
    ball.setFilled(true);
    add(ball);
}

public void play() {
    while (ball.getY() < 200) {
        ball.move(5, 5);
        pause(DELAY);
    }
}
}