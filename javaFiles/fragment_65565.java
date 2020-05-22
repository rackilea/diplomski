counter = 0;
t = new Timer(50, new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        if(counter>=130)
            t.stop();

        counter++;
        x++;
        y++;
        drawPanel.repaint();
    }
});
t.start();