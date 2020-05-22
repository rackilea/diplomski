public class TicTacToe extends JFrame implements ActionListener {

    public static final String X = "X";
    public static final String O = "O";

    .
    .
    .

    public void actionPerformed(ActionEvent event) {
        JButton button = (JButton) event.getSource();

        if (button.getText().isEmpty()) {
            button.setText(X);
        } else if (button.getText().equals(X)) {
            button.setText(O);
        } else {
            button.setText("");
        }
    }
}