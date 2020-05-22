public class Paddle {
    public void stop() {
        speed = 0;
        direction = NEUTRAL;        
    }

    public void update(float deltaTime) {
        // here, x is valid
        x += (direction == LEFT?-1:+1) * speed * deltaTime;

        if (x < 0) {
            x = 0;
            stop();
        }
        else if (x > 800) {
            x = 800;
            stop();
        }

        // here, x is valid
    }
}

public class Pong {
    public void update(float deltaTime) {
        if (inBounds) {
            x += speedX * deltaTime;
            y += speedY * deltaTime;
            if (x + WIDTH >= 800) {
                speedX *= -1;
                x = 800-WIDTH-1;
            }
            if (x <= 0) {
                speedX *= -1;
                x = 1;
            }
            if (y >= 1280) {
                speedY *= -1;
                y = 1279;
            }
            if (y <= 0) {
                speedY *= -1;
                y = 1;
            }

            // here, Pong is in screen
        }

    }
}