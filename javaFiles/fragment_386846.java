public class Main {

    private String formula;


    ActionListener yesListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (formula == null) {
                formula = textArea.getText();
            }
            int i = StringUtils.countMatches(formula, "?");
            if (i > 1) {
                formula = findTrue(formula);
                questionLabel.setText(askQuestion(formula));
            } else {
                questionLabel.setText("The formula will return" + findTrue(formula));
            }
        }

    };