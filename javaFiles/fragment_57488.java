Component comp = new Componenet();
comp.addKeyListener(new KeyListener() {
    public void keyTyped(KeyEvent e) {
        System.out.print("Hello");
    }

    public void keyPressed(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}
});

try {
    Thread.sleep(1000);
} catch (Exception e) {
}
System.exit(0);