if(goingDown) {
        //velocityY = Math.sqrt(100 + 2*gravity*(posY));
        velocityY = gravity*(currentFrame - runTime);
    } else {
        velocityY = downV - gravity*(currentFrame - runTime);
    }