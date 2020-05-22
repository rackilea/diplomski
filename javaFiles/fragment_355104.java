//how far the player can move this frame (distance = speed * time):
float maxDistance = SPEED * Gdx.graphics.getDeltaTime();

//a vector from the player to the touch point:
tmp.set(touchPos.x, touchPos.y).sub(player1Rectangle.x, player1Rectangle.y); 

if (tmp.len() <= maxDistance) {// close enough to just set the player at the target
    player1Rectangle.x = touchPos.x;
    player1Rectangle.y = touchPos.y;
} else { // need to move along the vector toward the target
    tmp.nor().scl(maxDistance); //reduce vector length to the distance traveled this frame
    player1Rectangle.x += tmp.x; //move rectangle by the vector length
    player1Rectangle.y += tmp.y;
}