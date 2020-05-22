import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.Timer;
import javax.swing.border.TitledBorder;

public class Example {
    private int choice;
    private JTextArea log;

    public Example() {
        log = new JTextArea();
        log.setEditable(false);
        JFrame frame = new JFrame();
        frame.add(log);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        showConfirmDialog(frame);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Example();
            }
        });
    }

    public void showConfirmDialog(Component parent) {
        Timer timer = new Timer(0, null);
        Timer timer2 = new Timer(0, null);
        log.append("Will automatically press 'Yes' after 10 seconds.\n");
        timer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Window window : Window.getWindows()) {
                    if (window instanceof JDialog) {
                        JDialog dialog = (JDialog) window;
                        if (dialog.getContentPane().getComponentCount() == 1
                                && dialog.getContentPane().getComponent(0) instanceof JOptionPane
                                && dialog.getTitle().equals("Dialog")) {
                            dialog.dispose();
                            choice = JOptionPane.YES_OPTION;
                            log.append("Programmatically pressed 'Yes' on the JOptionPane due to inactivity of user\n");
                        }
                    }
                }
                timer.stop();
                timer2.stop();
            }
        });
        timer.setInitialDelay(10 * 1000);
        timer.start();

        choice = JOptionPane.showConfirmDialog(parent, "", "Dialog", JOptionPane.YES_NO_CANCEL_OPTION);
        if (choice == JOptionPane.NO_OPTION) {
            log.append("Dialog will reappear in 5 seconds\n");
            timer2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    log.append("Dialog reappeared\n");
                    showConfirmDialog(parent);
                    timer2.stop();
                }
            });
            timer2.setInitialDelay(5 * 1000);
            timer2.start();
        }
        timer.stop();
    }
}