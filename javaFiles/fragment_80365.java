class Player {

    float gravity = 0.1;
    float speed = 0;
    float playerXPosition;
    float playerYPosition;

    // [...]

    void steuerungH(){
        if (key == UP|| key == 'w') {
            playerYPosition = playerYPosition +speed;
            speed = speed + gravity;
            if (playerYPosition >= 30); {
                speed = speed *-1;
            }
        } else if (key == DOWN ||key == 's') {
            /*Duck methode muss noch geschrieben werden*/
        } else if (key == RIGHT || key == 'd') {
            playerXPosition = playerXPosition +10;
        } else if (key == LEFT ||key == 'a') {
            playerXPosition = playerXPosition -10;
        }
    }
}