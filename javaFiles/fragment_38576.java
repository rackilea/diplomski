if(!pleaseWait) {
    canvas = this.surfaceHolder.lockCanvas();

    if (canvas != null) {
        // try locking the canvas for exclusive pixel editing on the surface
        try {
            if (ScaleGame)
                canvas.setMatrix(matrix);
            synchronized (surfaceHolder) {
                startTime = System.currentTimeMillis();
                this.gamePanel.update((float)elapsedTime);
                canvas.drawBitmap(screen, 0, 0, paint);
                elapsedTime = System.currentTimeMillis() - startTime;
        }
        finally {
            surfaceHolder.unlockCanvasAndPost(canvas);
        }            
    }
}