EventQueue.invokeLater(new Runnable() {
    @Override
    public void run() {
        this.setLocation(x, y);
        this.repaint();
    });