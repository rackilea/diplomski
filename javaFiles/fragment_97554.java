if (bord[ypos + 1][xpos - 1] == 1) {
    bord[ypos + 1][xpos - 1] = 4;
}
if (bord[ypos + 1][xpos + 1] == 1) {
    bord[ypos + 1][xpos + 1] = 4;
}
repaint();
Timer timer = new Timer(2000, new ActionListener() {
    public void actionPerformed(ActionEvent evt) {
        if (bord[ypos + 1][xpos - 1] == 4) {
            bord[ypos + 1][xpos - 1] = 1;
        }
        if (bord[ypos + 1][xpos + 1] == 4) {
            bord[ypos + 1][xpos + 1] = 1;
        }
    }
});
timer.setRepeats(false);
timer.start();