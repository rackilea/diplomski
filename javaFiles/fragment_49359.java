private double rotation;

// ...

@Override
public void keyPressed(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
        rotation = (rotation + Math.toRadians(10)) % (Math.PI * 2);
        repaint();
    }
}