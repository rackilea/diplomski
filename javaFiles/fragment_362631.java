int width, height, rows, columns;
int gridWidth, gridHeight;
int targetX, targetY, x, y = 0;

boolean isRunning = true;

public GridPanel(int width, int height, int rows, int columns) {
    this.width = width;
    this.height = height;
    this.rows = rows;
    this.columns = columns;

    gridHeight = height / rows;
    gridWidth = width / columns;

    setPreferredSize(new Dimension(width, height));
}

@Override
public void paint(Graphics g) {
    g.clearRect(0, 0, width, height);

    // Draw grid
    g.setColor(Color.GRAY);
    for (int i = 1; i <= rows; i++) {
        g.drawLine(0, i * gridHeight, width, i * gridHeight);
    }
    for (int j = 1; j <= columns; j++) {
        g.drawLine(j * gridWidth, 0, j * gridWidth, height);
    }

    // Draw green block for movement
    g.setColor(Color.GREEN);
    g.fillRect(x, y, gridWidth, gridHeight);
}

public void moveTo(int x, int y) {
    targetX = x * gridWidth;
    targetY = y * gridHeight;

    isRunning = true;
    // Start your animation thread
    new Thread(new Runnable() {
        @Override
        public void run() {
            while (isRunning) {
                moveRobot();
                try {
                    Thread.sleep(700); // Customize your refresh time
                } catch (InterruptedException e) {
                }
            }
        }
    }).start();
}

private void moveRobot() {
    // Add all your path movement related code here
    int newX = x + gridWidth;
    int newY = y + gridHeight;
    if (newX >= width || newX >= targetX) {
        y = newY;
    } else {
        x = newX;
    }
    if (newX >= targetX && newY >= targetY) {
        // Reached target grid. Stop moving
        isRunning = false;
        return;
    }
    // Repaint the screen
    repaint();
}