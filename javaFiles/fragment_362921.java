class popup {

    private JFrame frmpopup;

    public popup() {
        initialize();
    }

    private void initialize() {
        frmpopup = new JFrame();
        frmpopup.getContentPane().setBackground(SystemColor.controlHighlight);
        frmpopup.setTitle("Standard Form");
        frmpopup.setBounds(100, 100, 224, 269);
        frmpopup.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void show() {
        frmpopup.setVisible(true);
    }

    public boolean isDisplayed() {
        if (frmpopup.isDisplayable())
            return true;
        else
            return false;
    }

}