import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

public class Test {

    private static final long serialVersionUID = 1L;
    private JDialog dialog = new JDialog();
    private final JPanel contentPanel = new JPanel();
    private Timer timer1;
    private JButton killkButton = new JButton("Kill JDialog");
    private JButton okButton = new JButton("OK");

    public Test() {
        contentPanel.setLayout(new FlowLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        JPanel buttonPane = new JPanel();
        okButton.setActionCommand("OK");
        buttonPane.add(okButton);
        killkButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        killkButton.setActionCommand("Kill JDialog");
        buttonPane.add(killkButton);
        dialog.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        dialog.addWindowListener(new WindowListener() {

            public void windowOpened(WindowEvent e) {
            }

            public void windowClosing(WindowEvent e) {
                startTimer();
            }

            public void windowClosed(WindowEvent e) {
            }

            public void windowIconified(WindowEvent e) {
            }

            public void windowDeiconified(WindowEvent e) {
            }

            public void windowActivated(WindowEvent e) {
            }

            public void windowDeactivated(WindowEvent e) {
            }
        });
        dialog.setLayout(new BorderLayout());
        dialog.getRootPane().setDefaultButton(okButton);
        dialog.add(buttonPane, BorderLayout.SOUTH);
        dialog.add(contentPanel, BorderLayout.CENTER);
        dialog.pack();
        dialog.setLocation(100, 100);
        dialog.setVisible(true);
        setKeyBindings();
    }

    private void setKeyBindings() {
        okButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke("ENTER"), "clickENTER");
        okButton.getActionMap().put("clickENTER", new AbstractAction() {

            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.setVisible(false);
                startTimer();
            }
        });
    }

    private void startTimer() {
        timer1 = new Timer(1000, new AbstractAction() {

            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        dialog.setVisible(true);
                    }
                });
            }
        });
        timer1.setDelay(500);
        timer1.setRepeats(false);
        timer1.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                Test test = new Test();
            }
        });
    }
}