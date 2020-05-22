class PoseActionListener implements ActionListener {

    private JButton button;
    private int a, b;

    public PoseActionListener(JButton btn, int a, int b) {
        this.button = btn;
        this.a = a;
        this.b = b;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        posePion(a, b, btn);
    }
}