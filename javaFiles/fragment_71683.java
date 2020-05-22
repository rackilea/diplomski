boolean movingDown = true;

void checkforCollision(){
if(circle.intersects(bottomWall.getBoundsInLocal()){
      movingDown = !movingDown;
      // do something
    }

else if(circle.intersects(rectangle.getBoundsInParent()) && !movingDown{
      movingDown = !movingDown;
      // do something
    }
// etc..
}