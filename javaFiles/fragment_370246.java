g2d.setColor(Color.RED);
g2d.fillRoundRect(
        5,
        5, 90,
        10, 5, 5);

g2d.setColor(Color.GREEN);
g2d.fillRoundRect(
        5, 5,
        (int)((health / totalHealth) * 90), 10, 5, 5);

g2d.setColor(Color.BLACK);
g2d.drawRoundRect(
        5, 5,
        90, 10, 5, 5);