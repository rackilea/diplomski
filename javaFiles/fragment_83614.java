SwingUtilities.invokeLater(new Runnable() {
    @Override
    public void run() {
        showMessageDialog(rootPane,
            "The checkbox selection did not work.",
            "SSCCE",
            INFORMATION_MESSAGE);
    }
});