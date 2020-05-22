public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (currentMessage.equals(message1)) {
            removeAll();
            drawStringMiddleOfPanel(message1, g);
        }
 }