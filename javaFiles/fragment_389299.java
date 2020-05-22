private int xDelta = 2;

@Override
public void actionPerformed(ActionEvent e) {

    x += xDelta;
    if (x + star.getWidth(this) >= B_WIDTH) {
        xDelta *= -1;
        x = B_WIDTH - star.getWidth(this);
        bounce.play();
    } else if (xDelta <= 0) {
        xDelta *= -1;
        x = 0;
        bounce.play();
    }

    if (y < B_HEIGHT && goingDown == true) {
        y += 2;
    } else if (y >= B_HEIGHT) {
        bounce.play();
        goingDown = false;
    }

    if (!goingDown) {
        y -= 2;
    }

    if (y <= 0) {
        goingDown = true;
    }
    repaint();
}