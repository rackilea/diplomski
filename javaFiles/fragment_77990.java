// This is in your custom JPanel, which for simplicity is also its own MouseListener.
 // Assuming getHexagons() returns Hexagon[].
 // Assuming Hexagon implements MouseListener.

 private Hexagon lastHovered;

 public void mouseMoved(MouseEvent e) {
     Hexagon current = null;
     boolean changed = false;
     for (Hexagon hex : getHexagons()) {
         if (hex.contains(e.getX(), e.getY())) {
             current = hex;
             break;
         }
     }
     if (lastHovered != current) {
         changed = true;
         if (lastHovered != null) {
             lastHovered.mouseExited(e);
         }
         if (current != null) {
             current.mouseEntered(e);
         }
     }
     lastHovered = current;
     if (changed) {
         repaint();
     }
 }