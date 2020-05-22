@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 

        int animationFrameUsedForAllPainting = animationFrame;
        drawChanges(g, getDelta(), animationFrameUsedForAllPainting , FJPanle.FRAMES);
        drawSomethingElse(g, animationFrameUsedForAllPainting , ...);
        drawEvenMore(g, animationFrameUsedForAllPainting , ...);
    }