// get the angle from the center to the mouse position
angle = atan2( mouseY - height/2, mouseX - width/2 );
// calculate the shortest rotation direction
float dir = (angle - targetAngle) / TWO_PI;
dir = dir - Math.round(dir);
dir = dir * TWO_PI;

// ease rotation
targetAngle += dir * easing;