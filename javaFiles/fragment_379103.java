if (distance <= radius[i] + radius[j]){ //if distance between two balls has them touching/overlapping, change direction
    // undo last velocity update; now the balls aren't overlapping anymore
    positionX[i] = positionX[i] - velocityX[i] ;
    positionY[i] = positionY[i] - velocityY[i] ;
    positionX[j] = positionX[j] - velocityX[j] ;
    positionY[j] = positionY[j] - velocityY[j] ;
    // now reverse all velocity components
    velocityX[i] = -velocityX[i] ;
    velocityY[i] = -velocityY[i] ;
    velocityX[j] = -velocityX[j] ;
    velocityY[j] = -velocityY[j] ;
    }