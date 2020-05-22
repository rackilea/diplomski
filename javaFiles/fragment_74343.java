if (blackhole.gameover(atoom) && !messageHasBeenShown)
{
        messageHasBeenShown = true;
        JOptionPane.showMessageDialog(null, "You're Goneee in The Black Hole !!");
        venster.switchPanel();
}