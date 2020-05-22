@SuppressWarnings("serial")
public class FooGui02 extends JPanel {
    private static final Font BUTTON_FONT = new Font(Font.SANS_SERIF, Font.BOLD, 36);
    private static final Font ANZEIGE_FONT = new Font(Font.SANS_SERIF, Font.PLAIN, 24);
    private JTextField anzeige = new JTextField(10);
    RechnerInt interfaceRechner = new RechnerInt();

    public FooGui02() {
        anzeige.setFont(ANZEIGE_FONT);
        // anzeige.setEnabled(false);
        anzeige.setBackground(null);
        anzeige.setFocusable(false); // user can't interact with this

        // create a grid of 4 columns and variable rows:
        JPanel btnPanel = new JPanel(new GridLayout(0, 4));

        // create first row
        // add 3 blank JLabels
        for (int i = 0; i < 3; i++) {
            btnPanel.add(new JLabel());
        }
        btnPanel.add(createOperationButton(Operation.DIVISION));

        // second row
        btnPanel.add(createNumberButton(7));
        btnPanel.add(createNumberButton(8));
        btnPanel.add(createNumberButton(9));
        btnPanel.add(createOperationButton(Operation.MULTIPLICATION));

        // third row
        btnPanel.add(createNumberButton(4));
        btnPanel.add(createNumberButton(5));
        btnPanel.add(createNumberButton(6));
        btnPanel.add(createOperationButton(Operation.SUBTRACTION));

        // forth row
        btnPanel.add(createNumberButton(1));
        btnPanel.add(createNumberButton(2));
        btnPanel.add(createNumberButton(3));
        btnPanel.add(createOperationButton(Operation.ADDITION));

        // fifth row
        btnPanel.add(new JLabel());
        btnPanel.add(createNumberButton(0));
        btnPanel.add(createOperationButton(Operation.CLEAR));
        btnPanel.add(createOperationButton(Operation.EQUALS));

        setLayout(new BorderLayout());
        add(anzeige, BorderLayout.PAGE_START);
        add(btnPanel);
    }

    private JButton createOperationButton(Operation operation) {
        JButton button = new JButton(operation.getText());
        button.addActionListener(new OperationListener(operation));
        button.setFont(BUTTON_FONT);
        return button;
    }

    private JButton createNumberButton(int number) {
        JButton button = new JButton("" + number);
        button.addActionListener(new NumberListener(number));
        button.setFont(BUTTON_FONT);
        return button;
    }

    private class OperationListener implements ActionListener {
        private Operation operation;

        public OperationListener(Operation operation) {
            this.operation = operation;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String text = anzeige.getText();

            switch (operation) {
            case CLEAR:
                interfaceRechner.operators.clear();
                interfaceRechner.numbers.clear();
                interfaceRechner.numbersInt.clear();
                anzeige.setText("");
                break;

            case ADDITION:
                interfaceRechner.addNumber(Integer.valueOf(text));
                interfaceRechner.addOperators("+");
                anzeige.setText("");
                break;

            case SUBTRACTION:
                interfaceRechner.addNumber(Integer.valueOf(text));
                interfaceRechner.addOperators("-");
                anzeige.setText("");
                break;

            case MULTIPLICATION:
                interfaceRechner.addNumber(Integer.valueOf(text));
                interfaceRechner.addOperators("*");
                anzeige.setText("");
                break;

            case DIVISION:
                interfaceRechner.addNumber(Integer.valueOf(text));
                interfaceRechner.addOperators("/");
                anzeige.setText("");
                break;

            case EQUALS:
                interfaceRechner.addNumber(Integer.valueOf(text));
                interfaceRechner.addOperators("=");
                anzeige.setText("" + interfaceRechner.berechneInt());
                interfaceRechner.operators.clear();
                interfaceRechner.numbers.clear();
                interfaceRechner.numbersInt.clear();
                break;

            default:
                break;
            }
        }
    }

    private class NumberListener implements ActionListener {
        private int number;

        public NumberListener(int number) {
            this.number = number;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String text = anzeige.getText();
            text += number;
            anzeige.setText(text);
        }
    }

    private static void createAndShowGui() {
        FooGui02 mainPanel = new FooGui02();

        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}