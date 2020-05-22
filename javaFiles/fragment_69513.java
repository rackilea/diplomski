public void simpleH(Graphics g, int x, int y, int tamaño, int steps){
    if (steps == 0)
        return;
    g.drawLine(x, y, x, y+tamaño); //right
    g.drawLine(x, y+tamaño/2, x+tamaño, y+tamaño/2); //middle
    g.drawLine(x+tamaño,y,x+tamaño,y+tamaño); //left

    //TopLeft
    simpleH(g,x-tamaño/4,y+tamaño*3/4,tamaño/2,steps-1);
    //BottomLeft
    simpleH(g,x-tamaño/4,y-tamaño/4,tamaño/2,steps-1);
    //TopRight
    simpleH(g,x+tamaño*3/4,y+tamaño*3/4,tamaño/2,steps-1);
    //BottomRight
    simpleH(g,x+tamaño*3/4,y-tamaño/4,tamaño/2,steps-1);
}