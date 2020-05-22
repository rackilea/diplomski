@Override
    public void mouseWheelMoved(MouseWheelEvent e) {

        //Zoom in
        if(e.getWheelRotation()<0){
            mydrawer.setZoomFactor(1.1*mydrawer.getZoomFactor());
            mydrawer.repaint();
        }
        //Zoom out
        if(e.getWheelRotation()>0){
            mydrawer.setZoomFactor(mydrawer.getZoomFactor()/1.1);
            mydrawer.repaint();
        }
    }