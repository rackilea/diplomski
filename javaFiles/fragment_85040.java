if(posY > h - ballRadius*2) {
        //initY = initY - 0.25F;
        //if(initY < 0) initY = 0;
        Log.i("xxx", String.valueOf(initY));
        runTime = currentFrame;
        downV = velocityY;
        goingDown = false;
    }