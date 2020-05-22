class MyJPanel extends JPanel {
    private int animationFrame = 0;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 

        drawChanges(g, getDelta(), animationFrame, FJPanle.FRAMES);
        drawSomethingElse(g, animationFrame, ...);
        drawEvenMore(g, animationFrame, ...);
    }

    ...
}