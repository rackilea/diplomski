public void resize(int width, int height) {
    getViewport().update(width, height, true);
    getViewport().getcamera().viewportWidth = YourScreenWidth / 16f;
    getViewport().getcamera().viewportHeight = YourScreenHeight / 16f;
    //set the camera to start from 0,0 and not from the center of the screen
    getViewport().getcamera().setToOrtho(false,                                            
                                        getViewport().getcamera().viewportWidth / 2f,
                                        getViewport().getcamera().viewportHeight/ 2f);

   getViewport().getcamera().update();
 }