public static void moveMissile(Graphics g){
    if(missileActive){
        drawMissile(g, BACKGROUND_COLOR);
        missilePositionX += missileDeltaX;
        missilePositionY += missileDeltaY;
        drawMissile(g, MISSILE_COLOR);
        if(missilePositionY <= 0){
            missileDeltaY = Math.abs(missileDeltaY);
            missilePositionY += missileDeltaY;
        }
        if(missilePositionX >= 300){
            missilePositionX += -Math.abs(missileDeltaX);
        }
        if(missilePositionX <=0){
            missileDeltaX = Math.abs(missileDeltaX);
            missilePositionX += missileDeltaX;
        }
        if(missilePositionY >= 300){
            drawMissile(g, BACKGROUND_COLOR);
            missileActive = false;
        }
        if( detectHitTarget((int)missilePositionX, (int)missilePositionY, (int)MISSILE_SIZE/2, targetPositionX, TARGET_POSITION_Y, TARGET_SIZE/2)){
            hitCount ++;
            drawMissile(g, BACKGROUND_COLOR);//erase the missile;
            missileActive = false;
        }
    }
}