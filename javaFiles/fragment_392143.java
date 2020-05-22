long framerate = 1000 / 60;
    // time the frame began. Edit the second value (60) to change the prefered FPS (i.e. change to 50 for 50 fps)
    long frameStart;
    // number of frames counted this second
    long frameCount = 0;
    // time elapsed during one frame
    long elapsedTime;
    // accumulates elapsed time over multiple frames
    long totalElapsedTime = 0;
    // the actual calculated framerate reported