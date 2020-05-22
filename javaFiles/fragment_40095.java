import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Sample2 implements ActionListener {
    JFrame mainFrame;

    JPanel bottom;
    JPanel center;
    JPanel centerPanel1;
    JPanel centerPanel2;

    static int count = 0;
    static int width_textfield = 10;
    static int height_textfield = 40;
    static int height = 0;

    JButton addTextField, submit;
    JTextField virtualDirectories;
    JLabel virtualDirectoriesName;

    ArrayList<JTextField> fields = new ArrayList<JTextField>();
    ArrayList<String> texts = new ArrayList<String>();

    int maxFields = 10;

    public Sample2() {
        mainFrame = new JFrame("Add Virtual Directory");
        mainFrame.setSize(640, 640);
        mainFrame.setResizable(false);

        addTextField = new JButton();
        addTextField.setText("Add Virtual directory");
        addTextField.setBounds(10, 10, 200, 25);
        addTextField.addActionListener(this);

        submit = new JButton();
        submit.setText("Submit");
        submit.setBounds(180, 560, 100, 25);
        submit.addActionListener(this);

        center = new JPanel(new GridLayout(1, 2));

        centerPanel1 = new JPanel(new GridLayout(maxFields, 1, 0, 20));
        centerPanel2 = new JPanel();

        center.add(centerPanel1);
        center.add(centerPanel2);

        bottom = new JPanel(new FlowLayout());
        bottom.add(addTextField);
        bottom.add(submit);

        mainFrame.getContentPane().add(bottom, BorderLayout.SOUTH);
        mainFrame.getContentPane().add(center, BorderLayout.CENTER);
        mainFrame.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "Add Virtual directory") {

            if (count < maxFields) {

                JPanel p = new JPanel(new GridLayout(1, 2));

                virtualDirectoriesName = new JLabel("Virtual Directory" + "\t" + ":");
                virtualDirectories = new JTextField();

                p.add(virtualDirectoriesName);
                p.add(virtualDirectories);

                centerPanel1.add(p);

                texts.add(virtualDirectories.getText());
                fields.add(virtualDirectories);

                count++;
                // width_textfield++;
                height_textfield = height_textfield + 60;

                mainFrame.revalidate();
                mainFrame.repaint();

                // http://www.dreamincode.net/forums/topic/381446-getting-the-values-from-mutiple-textfields-in-java-swing/
            } else {
                JOptionPane.showMessageDialog(mainFrame, "can only add " + maxFields + " virtual Directories");
            }

        }
        if (e.getActionCommand() == "Submit") {
            ArrayList<String> texts = new ArrayList<String>();
            for (int i = 0; i < count; i++) {
                texts.add(fields.get(i).getText());
            }

            System.out.println(texts.size());
            System.out.println(texts.toString());
        }
    }

    public static void main(String[] args) {
        new Sample2();
    }

}