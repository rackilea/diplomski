public static void shootMissile(Graphics g){
    if(missileActive == false){
        missileActive = true;
        missilePositionX = shooterPositionX;
        missilePositionY = SHOOTER_POSITION_Y-SHOOTER_SIZE;
        missileDeltaX = 0;
        missileDeltaY = 0;
        missilePositionX += missileDeltaX;
        missilePositionY += missileDeltaY;
        missileDeltaY = - gunPositionY * MISSILE_SPEED;
        missileDeltaX = gunPositionX * MISSILE_SPEED;
    }
}