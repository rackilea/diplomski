Timer timer = new Timer(timeout, new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {
        component.repaint();
    }
});
timer.start();