public class Paddle {

public static int screenX;

  // This the the constructor method
// When we create an object from this class we will pass
// in the screen width and height
public Paddle(int screenX, int screenY){
this.screenX = screenX;
    // 130 pixels wide and 20 pixels high
    length = 130;
    height = 20;

    // Start paddle in roughly the sceen centre
    x = screenX / 2;
    y = screenY - 20;

    rect = new RectF(x, y, x + length, y + height);

    // How fast is the paddle in pixels per second
    paddleSpeed = 550;

}
  public void update(long fps){
    rect.left = x;
      rect.right = x + length;
      if (x<0){
         x=0;
      }
      else if (x+length > screenX){
         x = screenX-length;
      }
   }
}