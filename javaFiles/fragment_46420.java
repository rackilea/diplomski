@Override
    public void paintComponent(Graphics gr) {
        super.paintComponent(gr);
        Graphics2D g2 = (Graphics2D) gr;
        if (angle != 0) {
            // Moving to centroid
            g2.translate(getWidth()/2, getHeight()/2);
            g2.rotate(angle);
            // Moving back but using the string's dimensions
            // instead of the bounds (which have been changed)
            g2.translate(-stringWidth/2, -stringHeight/2);
        }
        g2.drawString("Hello World", 2, 12);
        if (angle != 0) {
            // Revert the transformation matrix back to its initial state
            g2.translate(stringWidth/2, stringHeight/2);
            g2.rotate(-angle);
            g2.translate(-getWidth()/2, -getHeight()/2);
        }
    }