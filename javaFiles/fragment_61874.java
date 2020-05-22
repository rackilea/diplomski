import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InvestmentFrame2 extends JFrame {

    private static final int FRAME_WIDTH = 450;
    private static final int FRAME_HEIGHT = 250;

    private static final double DEFAULT_RATE = 0;
    private static final double INITIAL_BALANCE = 0;
    private static final double YEARS = 0;

    private JLabel rateLabel;
    private JLabel balanceLabel;
    private JLabel yearsLabel;

    private JTextField rateField;
    private JTextField balanceField;
    private JTextField yearsField;

    private JButton button;

    private JLabel resultLabel;
    private double balance;

    public InvestmentFrame2() {
        balance = INITIAL_BALANCE;
        resultLabel = new JLabel("Balance: " + balance);

        createTextField();
        createButton();
        createPanel();

        setSize(FRAME_WIDTH, FRAME_HEIGHT);
    }

    private void createTextField() {
        rateLabel = new JLabel("Interest Rate: ");
        balanceLabel = new JLabel("Account Balance: ");
        yearsLabel = new JLabel("Number of Years Saving: ");

        final int FIELD_WIDTH = 10;

        rateField = new JTextField(FIELD_WIDTH);
        rateField.setText("" + DEFAULT_RATE);

        balanceField = new JTextField(FIELD_WIDTH);
        balanceField.setText("" + INITIAL_BALANCE);

        yearsField = new JTextField(FIELD_WIDTH);
        yearsField.setText("" + YEARS);
    }

    class AddInterestListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            double rate = Double.parseDouble(rateField.getText());
            double accountBalance = Double.parseDouble(balanceField.getText());
            double years = Double.parseDouble(yearsField.getText());
            double interest = (accountBalance * rate / 100) * years;
            balance = accountBalance + interest;
            resultLabel.setText("Balance: " + balance);
        }
    }

    private void createButton() {
        button = new JButton("Calculate Balance");

        ActionListener listener = new AddInterestListener();
        button.addActionListener(listener);
    }

    private void createPanel() {
        JPanel panel = new JPanel();
        panel.add(rateLabel);
        panel.add(rateField);

        panel.add(balanceLabel);
        panel.add(balanceField);

        panel.add(yearsLabel);
        panel.add(yearsField);

        panel.add(button);
        panel.add(resultLabel);
        add(panel);
    }

    public static void main(String[] args) {
        JFrame frame = new InvestmentFrame2();
        frame.setTitle("Savings Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}