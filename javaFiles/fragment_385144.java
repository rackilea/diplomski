SwingUtilities.invokeLater(new Runnable() {
    @Override
    public void run() {
        ta.scrollRectToVisible(new Rectangle(0, 0, 10, 10));
    }
});