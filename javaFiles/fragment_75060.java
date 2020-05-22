public void updateCount() {
        //change the racket position according to the movement
        if (racketIsMovingRight && (racketPosition.x+racketWidth/2)<=screenWidth) {
            racketPosition.x += racketSpeed;
        }

        if (racketIsMovingLeft && (racketPosition.x-racketWidth/2)>=0) {
            racketPosition.x -= racketSpeed;
        }