// In our example, TOTAL_LAYERS is 4
for (int i = 0; i < TOTAL_LAYERS; i++) {

    int tmpInt;
    Parallax parallax = parallaxList.get(i);

    parallax.update(deltaTime);

    // If one layer is off the edge, put it at the right of the next one
    // In this example, layers are moving from right to left
    if (parallax.position.x <= -parallax.width) {

        // We know that parallaxList's indexes 0 and 1 hold the back layers
        // and indexes 2 and 3 have the front layers. You can add additional
        // parameters in Parallax class to indicate a group so that you do not
        // have to determine the group in dirty way like this
        if(i == 0){
            tmpInt = 1;
        } else if(i == 1) {
            tmpInt = 0;
        } else if(i == 2) {
            tmpInt = 3;
        } else {
            tmpInt = 2;
        }

        parallax.setPosition(parallaxList.get(tmpInt).position.x + parallax.width, parallax.position.y);            
    }        
}