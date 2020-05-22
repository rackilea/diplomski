addKeyListener(new KeyAdapter() {
        public void keyPressed(KeyEvent ke) {
            if (ke.getKeyCode() == KeyEvent.VK_DOWN)
                label.setLocation(label.getX(), label.getY() + 1);
            if (ke.getKeyCode() == KeyEvent.VK_UP)
                label.setLocation(label.getX(), label.getY() - 1);
            if (ke.getKeyCode() == KeyEvent.VK_LEFT)
                label.setLocation(label.getX() - 1, label.getY());
            if (ke.getKeyCode() == KeyEvent.VK_RIGHT)
                label.setLocation(label.getX() + 1, label.getY());
        }
    });