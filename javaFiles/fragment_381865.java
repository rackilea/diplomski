// make objects
    GImage paddleLeftTexture = createTexture("texture.png", WIDTH + 1,
            HEIGHT + 1);
    GImage paddleRightTexture = createTexture("texture2.png", WIDTH + 1,
            HEIGHT + 1);
    GImage ballTexture = createTexture("ballTexture.png", (int) BALL_SIZE,
            (int) BALL_SIZE);
    GImage greenFlash = createTexture("greenFlash.png", 100, 300);
    GImage blueFlash = createTexture("blueFlash.png", 100, 300);
    GOval ball = makeBall();
    GRect paddleLeft = makePaddle();
    GRect paddleRight = makePaddle();
    greenFlash.setLocation(-200, 0);
    blueFlash.setLocation(-200, 0);

    // generate GUI
    drawGraphics(ball, paddleLeftTexture, paddleRightTexture, ballTexture,
            greenFlash, blueFlash, counter, paddleLeft, paddleRight,
            aiScore, playerScore);