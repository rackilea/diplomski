SwingUtilities.invokeLater(new Runnable() {
    @Override
    public void run() {
        System.setProperty("DEBUG_UI", "true");

        BorderLayoutFrame blf = new BorderLayoutFrame();
        blf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        blf.setSize(600,600);
        blf.setVisible(true);
    }
});