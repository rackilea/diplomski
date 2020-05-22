// disable '+' and '-' keys
button.addKeyListener(new KeyAdapter() {
    public void keyPressed(KeyEvent e) {
        if (e.character == '-' || e.character == '+') { 
            e.doit = false;
        }
    }
});