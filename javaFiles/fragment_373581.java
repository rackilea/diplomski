public static void main(String[] args) {
    String question =  "What is the Capital of South Africa?\n";
    question += "A. Cape town\n";
    question += "B. Pretoria\n";
    question += "C. Johannesburg\n";
    question += "D. Durban\n";
    question += "E. Nelspruit\n";

    String answer = JOptionPane.showInputDialog(question);
    answer = answer.toUpperCase();

    int guess = 0;
    while (answer != "B") {
        answer = JOptionPane.showInputDialog(question);
        answer = answer.toUpperCase();
        if (answer.equals("B")) {
            JOptionPane.showMessageDialog(null, "Correct!");
            break;
        } else if (answer.equals("A")) {
            JOptionPane.showMessageDialog(null, "Incorrect. Please try again!");
        } else if (answer.equals("C")) {
            JOptionPane.showMessageDialog(null, "Incorrect. Please try again!");
        } else if (answer.equals("D")) {
            JOptionPane.showMessageDialog(null, "Incorrect. Please try again!");
        } else if (answer.equals("E")) {
            JOptionPane.showMessageDialog(null, "Incorrect. Please try again!");
        } else {
            JOptionPane.showMessageDialog(null, "Invalid answer. Please enter A, B, C, D, or E.");
        }
        guess++;
    }
}