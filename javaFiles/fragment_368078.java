if(      (e.getPoint().x>=radio.getX() && e.getPoint().x<=radio.getX()+labelSize) && 
        (e.getPoint().y>=radio.getY() && e.getPoint().y<=radio.getY()+labelSize)
        )
{
    //Has the mouse been clicked inside the radio before grabbing started ?
    if(grab==0)  //if it is the first iteration of the function mousedragged
        grab=2;  //proceed to "grab"
}

if(grab==2 &&   (e.getPoint().x>=0 && e.getPoint().x<panel.getWidth()) && 
        (e.getPoint().y>=0 && e.getPoint().y<panel.getHeight())
        )
{   //Ja kursors ir uz JLabel, tad pārvieto;
    System.out.println(radio.getX()+" "+radio.getY());
    xAxisDrag.setText("X: "+((e.getPoint().x/4)-32));
    yAxisDrag.setText("Y: "+((e.getPoint().y/4)-32));
    radio.setBounds(e.getPoint().x-(labelSize/2), e.getPoint().y-(labelSize/2), labelSize, labelSize);

}
if(grab!=2)  // if grabbing is not started
   grab=1; // first iteration is over