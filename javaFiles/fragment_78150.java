Timer timer = new Timer(40, new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
});
timer.start();