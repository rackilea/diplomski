for (int i = 0; i < 14; i++) {
    int[] xC = new int[3];
    xC[0] = (int) (Math.random() * 400);
    xC[1] = xC[0] + (int) (Math.random() * 200);
    xC[2] = xC[1] + (int) (Math.random() * 4);
    int[] yC = new int[3];
    yC[0] = (int) (Math.random() * 200);
    yC[1] = yC[0] - (int) (Math.random() * 10);
    yC[2] = yC[0] - (int) (Math.random() * 3);
    g.setColor(Color.BLACK);
    g.fillPolygon(xC,yC,3);
}