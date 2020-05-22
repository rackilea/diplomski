public class Example {

    public static final JButton[] BUTTONS = new JButton[10];

    public static void main(String[] args) {

        for (int i = 0; i < BUTTONS.length; i++) {
            // initialize BUTTONS[i]
            BUTTONS[i].addActionListener(new MyActionListener(i));
        }
    }

    private static class MyActionListener implements ActionListener {

        int i;

        MyActionListener(int i) {

            this.i = i;
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            num = num * 10 + i;
            CalculatorGUI.resultLabel.setText(Double.toString(num));
        }
    }
}