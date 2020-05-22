private class TimerListener implements ActionListener {
    private JButton button;
    public MyListener(JButton button){
        this.button = button;
    }

    public void actionPerformed(ActionEvent e) {
        this.button.setIcon(guncold);
    }
}