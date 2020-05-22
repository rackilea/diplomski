while(true){
    if(!ourHolder.getSurface().isValid())
        continue; // should this be a break?
    Canvas canvas = ourHolder.lockCanvas();
    canvas.drawRGB(255, 0, 0);
    ourHolder.unlockCanvasAndPost(canvas);
}