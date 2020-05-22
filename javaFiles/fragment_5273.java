public void surfaceDestroyed(SurfaceHolder holder) {

        boolean retry = true;

        if (gameLoop != null) {

            gameLoop.running = false;

            while (retry) {
                try {
                    gameLoop.join();
                    retry = false;  
                } catch (InterruptedException e) {
                }
            }
        }
        gameLoop = null;
}