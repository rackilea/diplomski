public class SpriteRaindrop extends Sprite{

     Rectangle raindrop = new Rectangle();

public SpriteRaindrop(Texture t, int srcWidth, 
                                 int srcHeigth, 
                                 float posX, 
                                 float posY){

      super(t, srcWidth, srcHeigth);

      raindrop.x      = posX;
      raindrop.y      = posY;
      raindrop.width  = srcWidth;
      raindrop.height = srcHeigth;

      setPosition(posX, posY);
 }

 public void updateR(){
     raindrod.x = getX();
     raindrod.y = getY();
 }
}