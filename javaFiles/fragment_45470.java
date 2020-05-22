public class DrawMap {

    Image tile;
    ...        

    public void render(Graphics g) throws SlickException {
    // your logic to draw in the image goes here

        // then we draw the image. The second and third parameter
        // arte the coordinates where to draw the image
        g.drawImage(this.tile, 0, 0);
    }   
}