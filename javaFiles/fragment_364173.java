int frames   = 0;
int fps = 60;
requestFocus();
while(running){
    long xnow = System.nanoTime();
    delta += (xnow-xlastTime) / xns;
    xlastTime = xnow;
    while (delta >= 1) {
        update();
        delta--;
    }
    render();
    frames++;

    if (System.currentTimeMillis() - timer > 1000){
        timer += 1000;
        fps = frames;
        frame.setTitle(title + " | " + fps + " fps");
        frames = 0;
    }
}
stop();