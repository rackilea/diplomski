@Override
public void onDraw(Canvas canvas) {

    float startX;
    float stopX;
    float startY;
    float stopY;

    int width = canvas.getWidth();
    int height = canvas.getHeight();

    int gridSize = 7;
    int gridSpacing = Math.min(width, height) / gridSize;
    int boardSize = gridSize * gridSpacing;

    int xOffset = (width - boardSize)/2;
    int yOffset = (height - boardSize)/2; 

    //Vertical Grid-lines
    for (int i = 0; i < gridSize; i++) {

        startX = xOffset + i*gridSpacing;
        startY = yOffset;

        stopX = startX;
        stopY = startY + boardSize;

        canvas.drawLine(startX, startY, stopX, stopY, black);

    }

    //Horizontal Grid-lines
    for (int i = 0; i < gridSize; i++) {

        startX = xOffset;
        startY = yOffset + i*gridSpacing;

        stopX = startX + boardSize;
        stopY = startY;

        canvas.drawLine(startX, startY, stopX, stopY, black);
    }
}