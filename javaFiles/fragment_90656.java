private final float MAX_SPEED = 2f;
private final float MIN_SPEED = 0.3f;

private final float DEFAULT_SPEED = 1f;

private final float ACCEL_SPEED = 0.1f;
private final float BRAKE_SPEED = 0.05f;

private float _speed = DEF_SPEED;

if (ButtonClicked)
{
    if (accelerate)
    {
        _speed = Math.min(_speed + ACCEL_SPEED, MAX_SPEED);
    }

    if (brake)
    {
        _speed = Math.max(_speed - BRAKE_SPEED, MIN_SPEED);
    }
}
else
{

    // only modify the speed if its far off to
    // prevent it from constantly accelerating and braking
    // (modify the 0.5f to increase/decrease the 'dead zone')
    if (Math.abs(_speed - DEFAULT_SPEED) > 0.5f)
    {
        // slowly reset to default speed
        if (_speed < DEFAULT_SPEED)
            _speed += ACCEL_SPEED;

        if (_speed > DEFAULT_SPEED)
            _speed -= BRAKE_SPEED;
    }
}