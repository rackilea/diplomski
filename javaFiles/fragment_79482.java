import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Example {

    public Example() {

        JButton button = new JButton("Button");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                CustomColorChooserDialog dialog = new CustomColorChooserDialog(button);
                dialog.setVisible(true);
            }
        });

        JFrame frame = new JFrame();
        frame.getContentPane().setLayout(new FlowLayout());
        frame.getContentPane().add(button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Example();
            }
        });
    }
}

class CustomColorChooserDialog extends JDialog {

    JComponent targetComponent;
    JColorChooser colorChooser;
    JButton backgroundButton;
    JButton foregroundButton;
    JButton okButton;

    public CustomColorChooserDialog(JComponent targetComponent) {

        this.targetComponent = targetComponent;

        colorChooser = new JColorChooser();

        ButtonActionListener listener = new ButtonActionListener();

        backgroundButton = new JButton("Set Background");
        backgroundButton.addActionListener(listener);

        foregroundButton = new JButton("Set Foreground");
        foregroundButton.addActionListener(listener);

        okButton = new JButton("OK");
        okButton.addActionListener(listener);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(backgroundButton);
        buttonPanel.add(foregroundButton);
        buttonPanel.add(okButton);

        getContentPane().add(colorChooser, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.PAGE_END);

        pack();
        setModal(true);
        setLocationRelativeTo(targetComponent);

    }

    private class ButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(backgroundButton)) {
                targetComponent.setBackground(colorChooser.getColor());
            } else if (e.getSource().equals(foregroundButton)) {
                targetComponent.setForeground(colorChooser.getColor());
            } else if (e.getSource().equals(okButton)) {
                dispose();
            }
        }
    }

}