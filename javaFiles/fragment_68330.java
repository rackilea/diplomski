public class GridSquare {

    private static int gridWidth = 10;
    private static int gridHeight = 10;

    public final int xPos;
    public final int yPos;

    public GridSquare(int x, int y){
        xPos = x;
        yPos = y;
    }

    public void drawOutLine(ShapeRenderer shapeRenderer){

         /*
         If the gridWidth and gridHeight don't change over time then you can
         move the calculation of the left, right, bottom and top positions 
         into the constructor for better performance.
         */
         int left = xPos * gridWidth;
         int right = left + gridWidth;
         int bottom = yPos * gridHeight;
         int top= bottom + gridHeight;

         shapeRenderer.line(left , top, left, bottom);
         shapeRenderer.line(right , top, right , bottom);
         shapeRenderer.line(left , top, right , top);
         shapeRenderer.line(left , bottom, right , bottom);
    }

    public void drawImage(Spritebatch spritebatch, Texture texture){

         /*
         If the gridWidth and gridHeight don't change over time then you can
         move the calculation of the left and bottom positions 
         into the constructor for better performance.
         */

        int left = xPos * gridWidth;
        int bottom = yPos * gridHeight; 

        spritebatch.draw(
                texture,
                left,
                bottom,
                gridWidth,
                gridHeight
        );
    }
}