for (int n; n < numBalls; n++) {
    BouncingBall ball = new BouncingBall(xpos.nextInt(300), 50,
            randomD1.
            nextInt(200), Color.BLUE, ground, myCanvas);
    ballMap.put(n, ball);
}

boolean finished = false;
while (!finished) {
    finished = true;
    for (int j = 0; j < ballMap.size(); j++) {
        BouncingBall selectedBall = ballMap.get(j);
        selectedBall.draw();
        // Only move the ball if it hasn't finished...
        if (selectedBall.getXPosition() < 550) {
            selectedBall.move(); // bounce the ball

            // stop once ball has travelled a certain distance on x axis
            if (selectedBall.getXPosition() < 550) {
                finished = false;
            }
        }
    }
    myCanvas.wait(50);           // small delay
}