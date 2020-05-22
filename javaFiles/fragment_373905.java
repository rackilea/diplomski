// Realistic value for sports car on street tires when using
// metric units. 10 m/s^2 is slightly over 1 g.
static const float MAX_ACCELERATION = 10.0f;

float deltaTime = ...;  // Time since last update.
float accelerationX = -veclocityY;
float accelerationY = velocityX;
float accelerationScale = MAX_ACCELERATION /
        sqrt(accelerationX * accelerationX + accelerationY * accelerationY);
accelerationX *= accelerationScale;
acceleration *= accelerationScale;
velocityX += accelerationX * deltaTime;
velocityY += accelerationY * deltaTime;
x += velocityX * deltaTime;
y += velocityY * deltaTime;