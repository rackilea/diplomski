private void gameRender() {
    if (DoubleBufferImage == null) {
        System.out.println("The Image is null: Error occurence");
        DoubleBufferImage = createImage(P_WIDTH - 15, P_HEIGHT - 15);
    }

    DoubleBufferGraphic = DoubleBufferImage.getGraphics();

    DoubleBufferGraphic.setColor(Color.LIGHT_GRAY);
    DoubleBufferGraphic.fillRect(0, 0, P_WIDTH, P_HEIGHT);

    DoubleBufferGraphic.setColor(Color.BLUE);
    DoubleBufferGraphic.setFont(font);
    DoubleBufferGraphic.drawString("Average FPS/UPS: " + 
            df.format(averageFPS) + df.format(averageUPS), 10, 10);
}