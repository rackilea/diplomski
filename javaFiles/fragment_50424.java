angleText.addKeyListener(new KeyAdapter() { //disables everything except number and dots
        public void keyTyped(KeyEvent e) {
            char input = e.getKeyChar();
            if ((input < '0' || input > '9') && input != '\b' && input != '.') {
                e.consume(); 
            }
        }
    });