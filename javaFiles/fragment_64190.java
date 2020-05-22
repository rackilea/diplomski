class Button1handler implements ActionListener {

    private JTextField f1;
    private JTextField f2;
    private JTextField f3;

    public Button1handler(JTextField f1, JTextField f2, JTextField f3) {
        this.f1 = f1;
        this.f2 = f2;
        this.f3 = f3;
    }

    public void actionPerformed(ActionEvent e) {
        int firstnumber = Integer.parseInt(f1.getText());
        int secondnumber = Integer.parseInt(f2.getText());
        int total = firstnumber + secondnumber;
        f3.setText(NumberFormat.getNumberInstance().format(total));
    }
}