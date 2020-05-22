private class MouseInput extends MouseAdapter{
    public void mouseClicked(MouseEvent e){
        if(layer==0){
            int x = e.getX();
            int y = e.getY();
            log.info("About to modify geometry; x=" + x + "; y=" + y);
            modifyGeometry(x, y, currentTile);
        }
    }
}