SwingUtilities.invokeLater(new Runnable() {
    public void run() {
        createAndShowGUI();
    }
});
SwingUtilities.invokeLater(new Runnable() {
    public void run() {
        doSomethingElse();
    }
});