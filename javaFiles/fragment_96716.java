const float increment = 1.0;
float direction;
float joy = oJoystick.getAngle();
float ang = user.fAngle;
float fudge = 5.0;

if (abs (joy - ang) > fudge) {
    if (joy > ang) {
        if (joy - ang < 180)
            direction = 1;
        else
            direction = -1;
    } else if (joy < ang) {       
        if (ang - joy < 180)
            direction = -1;
        else
            direction = 1;
    }
} else // already pointing right direction
    direction = 0;

user.fAngle = ang + direction * increment;
if (0 > user.fAngle)
    user.fAngle += 360;
if (360 < user.fAngle)
    user.fAngle -= 360;