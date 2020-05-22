import javax.swing.JOptionPane;

public class ThreeLetterAcronym {

    public static void main(String[] args) {
        String answer;
        String upperAnswer;
        int number;
        char letter;
        String initial = "";

        answer = JOptionPane.showInputDialog(null, "Please enter three words?", "Input", JOptionPane.QUESTION_MESSAGE);
        upperAnswer = answer.toUpperCase();
        upperAnswer = " " + upperAnswer;
        number = upperAnswer.length();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < number; i++) {
            letter = upperAnswer.charAt(i);
            if (letter == ' ') {
                initial = Character.toString(upperAnswer.charAt(i + 1));
                sb.append(initial);
                System.out.print(upperAnswer.charAt(i + 1));
            }
        }
        JOptionPane.showMessageDialog(null, sb.toString(), "Acronym", JOptionPane.INFORMATION_MESSAGE);
    }
}