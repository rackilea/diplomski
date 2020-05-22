if(     (e.getPoint().x>=radio.getX() && e.getPoint().x<=radio.getX()+labelSize) && 
        (e.getPoint().y>=radio.getY() && e.getPoint().y<=radio.getY()+labelSize)
        )
{   //Ja kursors ir uz JLabel, tad pārvieto;
    xAxisDrag.setText("X: "+((e.getPoint().x/4)-32));
    yAxisDrag.setText("Y: "+((e.getPoint().y/4)-32));
    radio.setBounds(e.getPoint().x-(labelSize/2), e.getPoint().y-(labelSize/2), labelSize, labelSize);
}