timer = new Timer(100, new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent ae) {
        // change polygon data
        // ...

        repaint();
    }
});