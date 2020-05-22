@Override
public void actionPerformed(ActionEvent e) {
    try {
        num = Integer.parseInt(answer.getText());
        if (e.getSource().equals(find)) {
            divisors = divisor(num);
            feedback.setText("The divisors are: " + divisors);

        }

    } catch (NumberFormatException ex) {
        feedback.setText("Invalid input. Enter an integer!");
        answer.setText("");
    }
}