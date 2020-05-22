if (right)
    rotationRate = maxRotationSpeed * (speed/topspeed);
if (left)
    rotationRate = maxRotationSpeed * (speed/topspeed);

direction += rotationRate * secondsElapsed;

double dir = Math.toRadians(direction - 90);
velocity = new Vector2D(speed * Math.cos(dir), speed * Math.sin(dir));