Timer timer = new Timer(5000, new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {
        cards.show(panel,"second");
    }
});
timer.setRepeats(false);
timer.start();