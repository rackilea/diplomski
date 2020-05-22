@SuppressWarnings("serial")
public final class TheGame extends JPanel implements MouseListener, ActionListener {
    public static final int WIDTH = 500, HEIGHT = 500;

    private final String START_SCORE = "0", 
            START_MESSAGE = "Get Ready ! Click to Start.",
            BACKGROUND_URL = "/res/flappy.png";

    private boolean currentlyPlaying, readyToJump, isAlive = true;
    private int score;

    private Timer timer;
    private Image background;
    private GameLabel messageLabel, scoreLabel;
    private Collection<Obstacle> obstaclesInOrder;
    private LinkedList<Obstacle> obstacles;
    private Ball ball;

    public TheGame() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        addMouseListener(this);
        timer = new Timer(50, this);

        background = loadBackgroundImage();
        messageLabel = new GameLabel(START_MESSAGE, 150, 240);
        scoreLabel = new GameLabel(START_SCORE, 250, 60);

        obstacles = new LinkedList<>();
        obstacles.removeAll(obstacles);
        obstaclesInOrder = Arrays.asList(new Obstacle(175, 20, 45), new Obstacle(320), new Obstacle(460), new Obstacle(585), new Obstacle(700));
        obstacles.addAll(obstaclesInOrder);
        ball = new Ball(30, 100);
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        if (!currentlyPlaying) {
            startGame();
        } else if (!isAlive) {
            reset();
        }

        readyToJump = true;
    }

    private void startGame() {
        currentlyPlaying = true;
        messageLabel.update("");
        timer.start();
    }

    private void endGame() {
        isAlive = false;
        scoreLabel.update("");
        messageLabel.update("Game Over. Your score was " + Integer.toString(score));
        timer.stop();
    }

    private void reset() {
        ball.reset();
        for (Obstacle obstacle : obstacles)
            obstacle.reset();

        messageLabel.update(START_MESSAGE, 150, 240);
        scoreLabel.update(START_SCORE, 250, 60);

        obstacles.removeAll(obstacles);
        obstacles.addAll(obstaclesInOrder);

        score = 0;
        isAlive = true;
        currentlyPlaying = false;
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        update();
        repaint();
    }

    private void update() {
        if (isAlive) {
            updateBallPosition();
            updateObstaclePositions();

            if(ballOutOfBounds() || playerCollidedWithObstacle()) {
                endGame();
            } else if(ballPassedObstacle()) {
                addToScore();
                setupNextObstacle();
            }
        }
    }

    private void updateBallPosition() {
        if (readyToJump) {
            readyToJump = false;
            ball.jump();
        } else {
            ball.fall();
        }
    }

    private void updateObstaclePositions() {
        for (Obstacle obstacle : obstacles) {
            if (obstacle.getX() <= -obstacle.getWidth()) {
                obstacle.moveToBack();
                continue;
            }

            obstacle.moveForward();
        }
    }

    private void addToScore() {
        scoreLabel.update(Integer.toString(++score));
    }

    private void setupNextObstacle() {
        obstacles.addLast(obstacles.removeFirst());
    }

    private boolean ballOutOfBounds() {
        return ball.getY() >= HEIGHT || ball.getY() <= 0;
    }

    private boolean ballAtObstacle() {
        Obstacle currentObstacle = obstacles.getFirst();
        return ball.getX() + ball.getWidth() >= currentObstacle.getX() && ball.getX() <= currentObstacle.getX() + currentObstacle.getWidth();
    }

    private boolean ballPassedObstacle() {
        Obstacle currentObstacle = obstacles.getFirst();

        return ball.getX() >= (currentObstacle.getX() + currentObstacle.getWidth());
    }

    private boolean playerCollidedWithObstacle() {
        boolean collided = false;

        if(ballAtObstacle()) {
                for (Obstacle obstacle : obstacles) {
                    RoundRectangle2D top = obstacle.getTop();
                    RoundRectangle2D bottom = obstacle.getBottom();

                    if (ball.intersects(top.getX(), top.getY(), top.getWidth(), top.getHeight()) || ball.intersects(bottom.getX(), bottom.getY(), bottom.getWidth(), bottom.getHeight())) {
                        collided = true;
                    }
                }
        }

        return collided;
    }

    private Image loadBackgroundImage() {
        Image background = null;
        URL backgroundPath = getClass().getResource(BACKGROUND_URL);

        if(backgroundPath == null) {
            background = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        } else {
            try {
                background = ImageIO.read(backgroundPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
       }

        return background;
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D g = (Graphics2D) graphics;

        g.drawImage(background, 0, 0, null);
        ball.paint(g);
        for (Obstacle obstacle : obstacles)
            obstacle.paint(g);

        scoreLabel.paint(g);
        messageLabel.paint(g);
    }

    //...
}