java.awt.EventQueue.invokeLater(new Runnable() {
    @Override
    public void run() {
        myFrame.toFront();
        myFrame.repaint();
    }
});