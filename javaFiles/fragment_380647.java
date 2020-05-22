import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;

public class TestTextArea100 {

    public static void main(String[] args) {
        new TestTextArea100();
    }

    public TestTextArea100() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private JTextArea message = new JTextArea(5, 20);
        private JLabel date = new JLabel();
        private JLabel ImageLabel = new JLabel();

        public TestPane() {
            this.setLayout(new GridBagLayout());
            this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
            this.setPreferredSize(new Dimension(550, 150));

            ImageLabel.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
            message.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
            ImageLabel.setText(":)");
            ImageLabel.setBorder(new LineBorder(Color.RED));

            message.setEditable(false);
            message.append("Blah");
            message.setLineWrap(true);
            message.setWrapStyleWord(true);
            message.setCaretPosition(message.getDocument().getLength());
            //message.setText(pmessage);
            message.setPreferredSize(new Dimension(400, 100));

            SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy hh:mm a");
            date.setText(f.format(new Date()));

            GridBagConstraints messageConst = new GridBagConstraints();
            messageConst.gridx = 0;
            messageConst.gridy = 0;
            messageConst.weightx = 1;
            messageConst.weighty = 1;
            messageConst.fill = GridBagConstraints.BOTH;

            messageConst.insets = new Insets(12, 12, 12, 12);

            GridBagConstraints iconConst = new GridBagConstraints();
            iconConst.gridx = 1;
            iconConst.gridy = 0;
            iconConst.insets = new Insets(12, 12, 12, 12);

            GridBagConstraints dateConst = new GridBagConstraints();
            dateConst.gridx = 0;
            dateConst.gridy = 1;
            dateConst.gridwidth = 2;
            dateConst.anchor = GridBagConstraints.EAST;

            this.add(message, messageConst);
            this.add(date, dateConst);
            this.add(ImageLabel, iconConst);
        }
    }

}