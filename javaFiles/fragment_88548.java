import javax.swing.*;

public class SpinnerModelTest {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                new SpinnerModelTest().makeUI();
            }
        });
    }

    public void makeUI() {
        SpinnerModel modeltau = new SpinnerNumberModel(0.0002, 0.0001, 100.0000, 0.0001);
        JSpinner spinner = new JSpinner(modeltau);
        ((JSpinner.NumberEditor) spinner.getEditor()).getFormat().setMaximumFractionDigits(4);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(spinner);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}