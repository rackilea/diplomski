public void mouseClicked(MouseEvent mouse){
    if(!drawPoint)
    {
        pointX = mouse.getX();
        pointY = mouse.getY();
        drawPoint = true;
    }    
    else if(!drawLine)
    {
        lineX = mouse.getX();
        lineY = mouse.getY();
        drawLine = true;
    }
    repaint();
}