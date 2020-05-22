public void updateSnake() {


    //every 100 ms or 1s the score increament
    long elapse = (System.nanoTime() - startTime) / 1000000;
    if (elapse > speed) {





        for (int i = snakeLength; i > 0; i--) {

            //                System.out.println("snake[i] = " + i + " bx loc " + snakeX[i] + " by loc " + snakeY[i]);
            snakeX[i] = snakeX[i - 1];

            snakeY[i] = snakeY[i - 1];
            //                System.out.println("snake[i] = " + i + " nbx loc " + snakeX[i] + " nby loc " + snakeY[i]);

        }

        switch (currentDirection) {
            case EAST:

                snakeX[0]++;
                angle = 0;
                break;
            case WEST:
                snakeX[0]--;
                angle = 180;
                break;
            case SOUTH:
                snakeY[0]++;
                angle = 90;
                break;
            case NORTH:
                snakeY[0]--;
                angle = 270;
                break;
        }

        //checks if hits the border so it could come from the opposite border
        //north and south

        if (snakeX[0] > numblocksWide) {
            snakeX[0] = 0;
        } else if (snakeX[0] < 0) {
            snakeX[0] = numblocksWide;
        }

        //east west

        if(snakeY[0] > maxHigh){
            snakeY[0] = minHigh;
        }else if(snakeY[0] < minHigh){
            snakeY[0] = maxHigh;
        }

        startTime = System.nanoTime();
    }

}