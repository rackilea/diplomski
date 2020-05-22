@Override
    public void mouseReleased(MouseEvent e)
    {
        //this a new line
        //grabbing is over
        grab=0;  // go back to idle state
        radio.setLocation(124, 124);
        xAxisDrag.setText("X: "+0);
        yAxisDrag.setText("Y: "+0);
    }