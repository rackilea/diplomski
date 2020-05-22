import java.awt.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class DocumentListenerExample {

    private JPanel contentPane;
    private JPanel compPanel;
    private JTextField firstField;
    private JTextField secondField;
    private JTextField thirdField;
    private JLabel resultLabel;

    private static final String RESULT = "Result : ";
    private int result;

    private void displayGUI() {
        JFrame frame = new JFrame("Document Listener Example");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        contentPane = new JPanel(new GridBagLayout());
        compPanel = new JPanel(new BorderLayout(5, 5));

        JPanel fieldPanel = new JPanel(new GridLayout(3, 3, 5, 5));
        JLabel firstLabel = new JLabel("First Number : ", JLabel.CENTER);
        firstField = new JTextField(10);
        firstField.getDocument().addDocumentListener(
                                    new MyDocumentListener());
        JLabel secondLabel = new JLabel("Second Number : ", JLabel.CENTER);
        secondField = new JTextField(10);
        secondField.getDocument().addDocumentListener(
                                    new MyDocumentListener());
        JLabel thirdLabel = new JLabel("Third Number : ", JLabel.CENTER);
        thirdField = new JTextField(10);
        thirdField.getDocument().addDocumentListener(
                                    new MyDocumentListener());
        fieldPanel.add(firstLabel);
        fieldPanel.add(firstField);
        fieldPanel.add(secondLabel);
        fieldPanel.add(secondField);
        fieldPanel.add(thirdLabel);
        fieldPanel.add(thirdField);

        JPanel footerPanel = new JPanel();
        resultLabel = new JLabel((RESULT + "0"), JLabel.CENTER);
        footerPanel.add(resultLabel);

        compPanel.add(fieldPanel, BorderLayout.CENTER);
        compPanel.add(footerPanel, BorderLayout.PAGE_END);
        contentPane.add(compPanel);

        frame.setContentPane(contentPane);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    private class MyDocumentListener implements DocumentListener {

        @Override
        public void changedUpdate(DocumentEvent de) {}

        @Override
        public void insertUpdate(DocumentEvent de) {
            calculateSum();
        }

        @Override
        public void removeUpdate(DocumentEvent de) {
            calculateSum();
        }

        private void calculateSum() {
            int first = 0, second = 0, third = 0;
            if (firstField.getDocument().getLength() > 0)
                first = Integer.parseInt(firstField.getText()); 
            if (secondField.getDocument().getLength() > 0)
                second = Integer.parseInt(secondField.getText());
            if (thirdField.getDocument().getLength() > 0)
                third = Integer.parseInt(thirdField.getText());
            result = first + second + third;
            resultLabel.setText(RESULT + result);
        }
    }

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                new DocumentListenerExample().displayGUI();
            }
        };
        EventQueue.invokeLater(runnable);
    }
}