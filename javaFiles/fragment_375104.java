if (up)
    acceleration = 100.0;
if (down)
    acceleration = -100.0;

speed += acceleration * secondsElapsed;

if (abs(speed) < 1.5) speed = 0;