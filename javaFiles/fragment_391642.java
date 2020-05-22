public void moveAlien() {

    for (Aliens a : aliens) { //List of Aliens (Enemy)
        Sprite s = a.getSprite(); //Get current enemy's sprite
        float targetX = spacemarine.getX(); //Player's X
        float targetY = spacemarine.getY(); //Player's Y
        float spriteX = s.getX(); //Enemy's X
        float spriteY = s.getY(); //Enemy's Y
        float x2 = s.getX(); //Enemy's new X
        float y2 = s.getY(); //Enemy's new Y
        float angle; // We use a triangle to calculate the new trajectory
            angle = (float) Math
                    .atan2(targetY - spriteY, targetX - spriteX);
            x2 += (float) Math.cos(angle) * 125
                    * Gdx.graphics.getDeltaTime();
            y2 += (float) Math.sin(angle) * 125
                    * Gdx.graphics.getDeltaTime();
            s.setPosition(x2, y2); //Set enemy's new positions.
        }
}