import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class TestTextPane {

    protected void initUI() {
        JFrame frame = new JFrame(TestTextPane.class.getSimpleName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JTextPane textPane2 = new JTextPane();
        textPane2.setText("12345");
        frame.add(textPane2);
        JButton button = new JButton("Make it red");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                final SimpleAttributeSet set = new SimpleAttributeSet();
                StyleConstants.setForeground(set, Color.RED);
                int p0 = textPane2.getSelectionStart();
                int p1 = textPane2.getSelectionEnd();
                if (p0 != p1) {
                    StyledDocument doc = textPane2.getStyledDocument();
                    doc.setCharacterAttributes(p0, p1 - p0, set, false);
                }
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        textPane2.getCaret().setDot(textPane2.getText().length());
                        MutableAttributeSet inputAttributes = textPane2.getInputAttributes();
                        inputAttributes.addAttributes(set);
                    }
                });

            }
        });
        button.setFocusable(false);
        frame.add(button, BorderLayout.SOUTH);
        frame.setSize(600, 400);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                TestTextPane t = new TestTextPane();
                t.initUI();
            }
        });
    }

}