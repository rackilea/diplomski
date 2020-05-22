final Sample a = new Sample();
SwingUtilities.invokeLater(new Runnable() {
    @Override
    public void run() {
        a.setVisible(true);
    }
});
this.dispose();