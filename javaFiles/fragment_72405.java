// a private inner class
private class MyActionListener implements ActionListener {
    private int index;

    public MyActionListener(int index) {
        this.index = index;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("index is: " + index);
        System.out.println("Action Command is: " + e.getActionCommand());
    }
}