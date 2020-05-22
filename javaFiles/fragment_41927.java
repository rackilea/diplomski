Timer time = new Timer(1000 / 20, new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {

        boolean refresh = false;

        switch (verticalMovement) {
        case UP:
            s2.changeY(UP);
            refresh = true;
            break;
        case DOWN:
            s2.changeY(DOWN);
            refresh = true;
            break;
        default:
            break;
        }

        switch (horizontalMovement) {
        case RIGHT:
            s2.changeX(RIGHT);
            refresh = true;
            break;
        case LEFT:
            s2.changeX(LEFT);
            refresh = true;
            break;
        default:
            break;
        }

        if (refresh == true) {
            pane.repaint();
        }
    }
});