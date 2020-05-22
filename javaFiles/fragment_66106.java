private void placeNewApple(){
    Coordinate newApple = apples.getRandom(); //<-- getRandom() returns a random Coordinate within the board        
    while(snake.contains(newApple)){
        newApple = apples.getNew();
    }
    placeApple(newApple);// method to place an apple at newApple.getX() , newApple.getY();
}