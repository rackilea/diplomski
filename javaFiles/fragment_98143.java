import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable {
    public static int playerHeight = 16;
    public static int playerWidth = 16;
    public static int movementSpeed = 3;

    public boolean running = false;

    private JFrame frame;
    private Image bufferImage;
    private Graphics bufferGraphics;
    private Input input;

    private Point playerLocation = null;

    private GameMap currentLevel;


    public Game() {
        Resources.loadResources();
        loadLevel(new GameMap.Level1());

        frame = new JFrame("PacMan"); // creates the frame for our game
        input = new Input();

        // if(MAIN_MENU == true && GAME == false){
        // buttons = new buttons(frame.getContentPane()); //draws the buttons
        // based on the code in our graphics/buttons.java
        // }

        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ends program on
                                                                // click of the
                                                                // Exit button
                                                                // in the top
                                                                // right corner
        frame.setLocationByPlatform(true);
        frame.addKeyListener(new Input());
        frame.add(this, BorderLayout.CENTER);
        frame.pack(); // keeps size correct
        frame.setResizable(false); // keep this false, if set to true whenever
                                    // someone resizes it our code will not
                                    // function correctly
        frame.setVisible(true);

        this.addKeyListener(input);
        this.createBufferStrategy(2); // I think this is double buffering,
                                        // honestly not too sure
    }

    /**
     * Loads the level into the game, also changes the dimensions of the window to fit the game
     * @param gameMap
     */
    private void loadLevel(GameMap gameMap) {
        currentLevel = gameMap;

        playerLocation = convertMapLocationToScreenLocation(currentLevel.getPlayerStartLocation());

        Dimension canvasSize = new Dimension(currentLevel.getWidth()*Resources.TILE_WIDTH, currentLevel.getHeight()*Resources.TILE_HEIGHT);

        setMinimumSize(canvasSize);
        setMaximumSize(canvasSize);
        setPreferredSize(canvasSize);

    }

    public void run() {
        long lastTime = System.nanoTime();
        double nsPerTick = 1000000000 / 60D;
        long lastTimer = System.currentTimeMillis();
        double delta = 0;

        int frames = 0;
        int ticks = 0;

        while (running == true) {
            long now = System.nanoTime();
            delta += (now - lastTime) / nsPerTick;
            lastTime = now;
            boolean render = false;

            while (delta >= 1) {
                ticks++;
                tick();
                delta -= 1;
                render = true;

            }

            try {
                Thread.sleep(20); // keep the Frames from going to high
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (render == true) {
                frames++;
                render();
            }

            if (System.currentTimeMillis() - lastTimer >= 1000) {
                lastTimer += 1000;

                frames = 0;
                ticks = 0;
            }
        }

        try {
            Thread.sleep(20); // keep the Frames from going to high
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void start() {
        new Thread(this).start();
        running = true;

    }

    public synchronized void stop() {
        running = false;
    }

    public void render() {
        Graphics g = getGraphics();
        if (bufferImage == null) {

            bufferImage = createImage(this.getSize().width, this.getSize().height);
            bufferGraphics = bufferImage.getGraphics();

        }

        bufferGraphics.setColor(Color.orange);
        bufferGraphics.fillRect(0, 0, this.getSize().width, this.getSize().height);

        drawGame(bufferGraphics);

        g.drawImage(bufferImage, 0, 0, this);
    }

    // this had to be renamed to drawGame, the paint method is used by AWT objects. This caused a serious bug where you would be constantly repainting.
    public void drawGame(Graphics g) {

        for (int x = 0; x < currentLevel.getWidth(); x++) {
            for (int y = 0; y < currentLevel.getHeight(); y++) {
                int tile = currentLevel.getTileAt(x, y);
                int tileX = x * Resources.TILE_WIDTH;
                int tileY = y * Resources.TILE_HEIGHT;

                if (tile == GameMap.TILE_WALL) {
                    g.drawImage(Resources.WALL, tileX, tileY, Resources.TILE_WIDTH, Resources.TILE_HEIGHT, null);
                }

                if (tile == GameMap.TILE_NOTHING) {
                    g.drawImage(Resources.BLACK_BACK, tileX, tileY,
                            Resources.TILE_WIDTH, Resources.TILE_HEIGHT, null);
                }

                if (tile == GameMap.TILE_POINT) {
                    g.drawImage(Resources.POINT, tileX, tileY,
                            Resources.TILE_WIDTH, Resources.TILE_HEIGHT, null);
                }
                /* This is not a good way to find the first location for the player, knowing that location belongs to the Map class
                if (tile == 5) {
                    if (!loaded) {
                        playerPosX = tileX;
                        playerPosY = tileY;
                        loaded = true;
                    }
                    g.drawImage(blackBack, tileX, tileY,
                            (int) 21.42857142857143, 26, null);
                }*/
            }
        }
        g.drawImage(Resources.PACMAN, playerLocation.x, playerLocation.y, playerWidth, playerHeight, null);
    }

    public void tick() {

        int nextPlayerPosX = playerLocation.x;
        int nextPlayerPosY = playerLocation.y;

        if (input.key_up) {
            nextPlayerPosY -= movementSpeed;
        }

        if (input.key_down) {
            nextPlayerPosY += movementSpeed;
        }

        if (input.key_left) {
            nextPlayerPosX -= movementSpeed;
        }

        if (input.key_right) {
            nextPlayerPosX += movementSpeed;
        }

        // lets make sure the next location doesnt collide with a wall, if so then dont move the pacman!
        if(!doesPlayerCollideWith(nextPlayerPosX, nextPlayerPosY, GameMap.TILE_WALL)) {
            playerLocation.setLocation(nextPlayerPosX, nextPlayerPosY);
        }
    }

    /**
     * Looks at the players screen location and gets the map tiles for each corner.
     * @param screenX
     * @param screenY
     * @return the 4 map tiles for each corner of the pac man given the screenX and screenY
     */
    private int[] getPlayerCornerCollisions(int screenX, int screenY) {
        int[] corners = new int[4];
        Point tileLocation = convertScreenLocationToMapLocation(screenX, screenY);
        corners[0] = currentLevel.getTileAt(tileLocation.x, tileLocation.y);

        tileLocation = convertScreenLocationToMapLocation(screenX + playerWidth, screenY);
        corners[1] = currentLevel.getTileAt(tileLocation.x, tileLocation.y);

        tileLocation = convertScreenLocationToMapLocation(screenX, screenY + playerHeight);
        corners[2] = currentLevel.getTileAt(tileLocation.x, tileLocation.y);

        tileLocation = convertScreenLocationToMapLocation(screenX + playerWidth, screenY + playerHeight);
        corners[3] = currentLevel.getTileAt(tileLocation.x, tileLocation.y);
        return corners;
    }

    /**
     * Checks if any corners of the player intersects with the given mapTileType
     * @param screenX
     * @param screenY
     * @param mapTileType
     * @return true if the player intersects with the given map tile type
     */
    public boolean doesPlayerCollideWith(int screenX, int screenY, int mapTileType) {
        for(int tileType : getPlayerCornerCollisions(screenX, screenY)) {
            if(tileType == mapTileType) {
                return true;
            }
        }
        return false;
    }

    /**
     * Takes the screen location and converts it to a coordinate in the map
     * @param location
     * @return
     */
    public Point convertScreenLocationToMapLocation(Point location) {
        return convertScreenLocationToMapLocation(location.x, location.y);
    }
    public Point convertScreenLocationToMapLocation(int x, int y) {
        return new Point(x/Resources.TILE_WIDTH, y/Resources.TILE_HEIGHT);
    }

    public Point convertMapLocationToScreenLocation(Point location) {
        return convertMapLocationToScreenLocation(location.x, location.y);
    }
    public Point convertMapLocationToScreenLocation(int x, int y) {
        return new Point(x*Resources.TILE_WIDTH, y*Resources.TILE_HEIGHT);
    }

    public static void main(String[] args) {
        new Game().start();
    }
}