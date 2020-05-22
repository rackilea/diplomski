SwingUtilities.invokeLater(new Runnable() {
    @Override
    public void run() {
        //create and show ui here
        CustomWindow w = new CustomWindow();
        w.setVisible(true);
    }
});