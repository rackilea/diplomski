void step(){
    int nextMove = rand.nextInt(3);
    if(nextMove == 0)
      moveUp();
    else if(nextMove == 1)
      moveDown();
    else if(nextMove == 2)
      moveLeft();
    else
      moveRight();
}