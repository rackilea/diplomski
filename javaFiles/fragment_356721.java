public class Example {

    public static final JButton[] BUTTONS = new JButton[10];

    public static void main(String[] args) {

        for (int i = 0; i < BUTTONS.length; i++) {
            // initialize BUTTONS[i]
            BUTTONS[i].setText(String.valueOf(i));
            BUTTONS[i].addActionListener(new MyActionListener());
        }
    }

    private static class MyActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            int i = Integer.parseInt(((JButton) e.getSource()).getText());
            num = num * 10 + i;
            CalculatorGUI.resultLabel.setText(Double.toString(num));
        }
    }
}