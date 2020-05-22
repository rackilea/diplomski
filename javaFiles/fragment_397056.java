private int player1Pointer = -1, player2Pointer = -1;

// render():    

//stop tracking released fingers
if (player1Pointer >=0 && !Gdx.input.isTouched(player1Pointer))
    player1Pointer = -1;
if (player2Pointer >=0 && !Gdx.input.isTouched(player2Pointer))
    player2Pointer = -1;

//check for new pointers and update target positions
for (int i = 0; i<20; i++){
    if (!Gdx.input.isTouched(i))
        continue;
    if (Gdx.input.getY(i) <= 400){ //bottom, player 1
        if (player2Pointer == i)
            continue; //player 2 slid finger across boundary, ignore it
        if (player1Pointer < 0)
            player1Pointer = i; //first finger down on this side of screen, track it
        if (player1Pointer == i){ //this is the tracked finger, update target
            player1TouchPosition.set(Gdx.input.getX(i), Gdx.input.getY(i), 0);
            camera.unproject(player1TouchPosition);
        }
    } else { //top, player 2
        if (player1Pointer == i)
            continue;
        if (player2Pointer < 0)
            player2Pointer = i;
        if (player2Pointer == i){
            player2TouchPosition.set(Gdx.input.getX(i), Gdx.input.getY(i), 0);
            camera.unproject(player2TouchPosition);
        }
    }
}

//update movement toward targets
maxDistance = 10 * Gdx.graphics.getDeltaTime();
temp.set(player1TouchPosition.x, player1TouchPosition.y).sub(player1Rectangle.x, player1Rectangle.y);
if (temp.len() <= maxDistance) {
    player1Rectangle.x = player1TouchPosition.x;
    player1Rectangle.y = player1TouchPosition.y;
} else {
    temp.nor().scl(maxDistance);
    player1Rectangle.x += temp.x;
    player1Rectangle.y += temp.y;
}
temp.set(player2TouchPosition.x, player2TouchPosition.y).sub(player2Rectangle.x, player2Rectangle.y);
if (temp.len() <= maxDistance) {
    player2Rectangle.x = player2TouchPosition.x;
    player2Rectangle.y = player2TouchPosition.y;
} else {
    temp.nor().scl(maxDistance);
    player2Rectangle.x += temp.x;
    player2Rectangle.y += temp.y;
}