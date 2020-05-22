@Override
  public void mousePressed(MouseEvent e) {
     if (ellipse.contains(e.getPoint())) {
        setRandomGradient();
        repaint();
     }
  }