//frame.add(canvas);

final JPanel panel = new JPanel();
panel.add(canvas);
frame.getContentPane().add(panel);
panel.addKeyListener(new KeyAdapter() {
    @Override
    public void keyPressed(final KeyEvent keyEvent) {
        System.out.println("keyEvent.getKeyCode(): " + keyEvent.getKeyCode());
    }
});