public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(drawLine){
            g.drawLine(pointX, pointY, lineX, lineY);
        }
        else if(drawPoint){
            g.drawOval(pointX-5,pointY-5,10,10);
        }
}