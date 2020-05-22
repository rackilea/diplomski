public class GameThing extends Applet {

    // External resources
    BufferedImage rightSprite, leftSprite, spriteDead, backgroundImg;

    // Game data
    int state = 1; //0 = left, 1 = right, 2 = dead

    // Geometry
    int locX = 100, locY = 300;
    int bgX = 0, bgY = 0;
    int groundX = 0, groundY = 334, groundW = 500, groundH = 50;
    int appletW = 600, appletH = 480;
    int wallW = 20, wallH = 40, wallX = 20, wallY = groundY - wallH;
    final int STEP_SIZE = 7;

    // Information
    final String X_LOC_STR = "Sprites Current X Location is: ";
    final String Y_LOC_STR = "Sprites Current Y Location is: ";
    final String STATE_STR = "Currently: ";
    final String X_BG_STR = "Background X location is: ";
    String stateString = "";

    // Double buffering
    Image offscreen;
    Graphics bufferGraphics;
    Dimension dim;

    // GUI components
    Panel gamePanel;
    Panel statusPanel = new Panel();
    Label xLocLabel = new Label();
    Label yLocLabel = new Label();
    Label stateLabel = new Label();
    Label xBGLocLabel = new Label();

    @Override
    public void init() {

        // Load images
        try {
            rightSprite = ImageIO.read(new File(getClass().getResource("SpriteRIght.png").getPath()));
            leftSprite = ImageIO.read(new File(getClass().getResource("SpriteLeft.png").getPath()));
            spriteDead = ImageIO.read(new File(getClass().getResource("SpriteDead.png").getPath()));
            backgroundImg = ImageIO.read(new File(getClass().getResource("Background.png").getPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Set the panel that displays data
        statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.Y_AXIS));
        statusPanel.add(xLocLabel);
        statusPanel.add(yLocLabel);
        statusPanel.add(stateLabel);
        statusPanel.add(xBGLocLabel);

        // Create the panel that draws the game and specify its behavior
        gamePanel = new Panel() {

            // Reduces flickering
            @Override
            public void update(Graphics g) {

                paint(g);
            }

            // DRAW MAIN CHARACTER SPRITE AND BACKGROUND
            @Override
            public void paint(Graphics g) {

                bufferGraphics.clearRect(0, 0, dim.width, dim.width);
                bufferGraphics.drawImage(backgroundImg, bgX, bgY, this);
                bufferGraphics.setColor(Color.BLACK); // DRAW GROUND (REPLACE WITH BLOCKS SOON)
                bufferGraphics.drawRect(groundX, groundY, groundW, groundH);
                bufferGraphics.setColor(Color.GREEN);
                bufferGraphics.fillRect(groundX, groundY + 1, groundW, groundH);
                bufferGraphics.setColor(Color.RED);
                bufferGraphics.fillRect(wallX, wallY, wallW, wallH);

                switch (state) {
                    case 0: bufferGraphics.drawImage(leftSprite, locX, locY, this);
                            break;
                    case 1: bufferGraphics.drawImage(rightSprite, locX, locY, this);
                            break;
                    case 2: bufferGraphics.drawImage(spriteDead, locX, locY, this);
                            // After death wait a bit and reset the game
                            EventQueue.invokeLater(new Runnable() {

                                @Override
                                public void run() {

                                    pause(2000);
                                    reset();
                                }
                            });
                            break;
                }
                g.drawImage(offscreen, 0, 0, this);
            }
        };

        // Set the applet window
        setLayout(new BorderLayout());
        add(statusPanel, BorderLayout.PAGE_START);
        add(gamePanel);

        // Set double buffering
        setSize(appletW, appletH);
        dim = getSize();
        offscreen = createImage(dim.width, dim.height);
        bufferGraphics = offscreen.getGraphics();

        // Set the panel that draws the game
        gamePanel.addKeyListener(new Controls());
        gamePanel.requestFocusInWindow();

        updateLabels();
    }   

    // PAUSE COMMAND LIFTED FROM RAY (who is Ray?)
    // waits a while
    public void pause(int delay) {

        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Set to start parameters
    public void reset() {

        locX = 100; locY = 300;
        bgX = 0;
        state = 1;
        gamePanel.repaint(); // These 2 lines automatically restart the game
        updateLabels();      // Remove if you want to stay on the death screen until next press
    }

    public void updateLabels() {

        xLocLabel.setText(X_LOC_STR + locX);
        yLocLabel.setText(Y_LOC_STR + locY);
        stateLabel.setText(STATE_STR + stateString);
        xBGLocLabel.setText(X_BG_STR + bgX);
    }

    private class Controls extends KeyAdapter {

        public void keyPressed(KeyEvent e) {

            switch (e.getKeyCode()) {

                case KeyEvent.VK_RIGHT:
                    stateString = "Moving Right!";
                    locX += STEP_SIZE;
                    state = 1;
                    if (locX > 121)
                        bgX -= STEP_SIZE;
                    // FALL DEATH
                    if ((locX > 490) && (locY > 300)) {
                        stateString = "You Died!";
                        state = 2;
                    }
                    // Start fall
                    if (locX == 499)
                        locY += STEP_SIZE;
                    // Check wall collision
                    if (locX >= wallX && locX <= wallX + wallW) {
                        locX -= STEP_SIZE;
                        stateString = "Wall!";
                    }
                    break;

                case KeyEvent.VK_LEFT:
                    stateString = "Moving Left!";
                    locX -= STEP_SIZE;
                    state = 0;

                    if (bgX < 0) 
                        bgX += STEP_SIZE;
                    // Check wall collision
                    if (locX >= wallX && locX <= wallX + wallW) {
                        locX += STEP_SIZE;
                        stateString = "Wall!";
                    }
                    break;

                case KeyEvent.VK_UP:
                    // Implement jumping
                    stateString = "Jumping!";
                    break;
            }

            // Repaint the game panel and update the data panel
            gamePanel.repaint();
            updateLabels();
        }
    }
}