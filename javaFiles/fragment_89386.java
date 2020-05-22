public void mouseMoved(MouseEvent e) {
        repaint(mouseX, mouseY, 20, 20);
        mouseX = e.getX();
        mouseY = e.getY();
        repaint(mouseX, mouseY, 20, 20);
    }