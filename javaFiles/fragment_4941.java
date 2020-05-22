public class changeLabel implements ActionListener {
    private final JLabel label;

    public changeLabel(JLabel label) {
        this.label = label;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        label.setText("Andrei");
    }
}