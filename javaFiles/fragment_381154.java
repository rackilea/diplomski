while(true) {
        if (up) {
            player.moveUp();
        } else if (down) {
            player.moveDown();
        }
        repaint();
    try {
        Thread.sleep(20);
    } catch (InterruptedException ex) {
        Logger.getLogger(Spaceshooter.class.getName()).log(Level.SEVERE, null, ex);
    }
    }