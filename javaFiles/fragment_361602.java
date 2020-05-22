Image scaled;

public void paint(Graphics g) {
    ...

    if (scaled == null) {
        scaled = unknown.getScaledInstacnce(100, 200);
    }

    ...

    g2d.drawImage(scaled, 10, button.getLocation().y - 200, this);
}