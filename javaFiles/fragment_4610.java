public void setupJFrame (JFrame frame, boolean maximize) {
    if (maximize) {
        frame.setExtendedState( frame.getExtendedState()|JFrame.MAXIMIZED_BOTH);
    } else {
        frame.setLocationRelativeTo(null);
    }
}