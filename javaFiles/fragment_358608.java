@Override
public void update(float dt) {
   handleInput();
   if(ObjectA.collides(ObjectB.getBounds())){     
       score++; 
       scoreName = "score: " + score; 
   }
}