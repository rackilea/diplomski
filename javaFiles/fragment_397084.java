window.addKeyListener(new KeyAdapter() {
        @Override
        public void keyPressed (KeyEvent e) {
            super.keyPressed(e);
            System.out.println("test "+e.getKeyChar());
        }
    });