import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class JavaFollowerNotifier1 extends JFrame{

    private JLabel controlDialogLabel = new JLabel("  ");
    private JLabel settingDialogLabel = new JLabel("  ");

    private JButton showControl = new JButton("Show Control");
    private JButton showSetting = new JButton("Show Settings");

    private ControlDialog control;
    private SettingsDialog settings;

    public JavaFollowerNotifier1() {
        control = new ControlDialog(this, true, controlDialogLabel);
        settings = new SettingsDialog(this, true, settingDialogLabel);


        showControl.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                control.setVisible(true);
            }
        });
        showSetting.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                settings.setVisible(true);
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(showControl);
        buttonPanel.add(showSetting);

        add(buttonPanel, BorderLayout.SOUTH);
        add(controlDialogLabel, BorderLayout.NORTH);
        add(settingDialogLabel, BorderLayout.CENTER);

        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new JavaFollowerNotifier1();
            }
        });
    }

}

class ControlDialog extends JDialog {
    private JLabel label;
    private JTextField field = new JTextField(15);
    private JButton button = new JButton("Close");
    private String s = "";

    public ControlDialog(final Frame frame, boolean modal, final JLabel label) {
        super(frame, modal);
        this.label = label;

        setLayout(new BorderLayout());
        add(field, BorderLayout.NORTH);
        add(button, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(frame);

        field.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                s = field.getText();
                label.setText("Message from Control Dialog: " + s);
            }
        });
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                ControlDialog.this.setVisible(false);
            }
        });
    }
}

class SettingsDialog extends JDialog {
    private JLabel label;
    private JTextField field = new JTextField(15);
    private JButton button = new JButton("Close");
    private String s = "";

    public SettingsDialog(final Frame frame, boolean modal, final JLabel label) {
        super(frame, modal);
        this.label = label;

        setLayout(new BorderLayout());
        add(field, BorderLayout.NORTH);
        add(button, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(frame);

        field.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                s = field.getText();
                label.setText("Message from Settings Dialog: " + s);
            }
        });
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                SettingsDialog.this.setVisible(false);
            }
        });
    }
}