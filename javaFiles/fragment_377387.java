import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BaseFrame extends JFrame {

    private String name;
    private double value1;
    private double value2;

    private final JMenuBar jMenuBar = new JMenuBar();
    private final JMenu jmOpen = new JMenu("Open");
    JMenuItem menuItemCreateSeller = new JMenuItem("Create Seller");
    InnerFrame innerFrame = new InnerFrame();

    public BaseFrame() {

        innerFrame.setResizable(false);
        jmOpen.add(menuItemCreateSeller);
        jMenuBar.add(jmOpen);

        setJMenuBar(jMenuBar);

        menuItemCreateSeller.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                innerFrame.setVisible(true);
            }
        });

        setSize(300, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                Frame frame = new BaseFrame();
            }
        });
    }

    private class InnerFrame extends JFrame {

        JPanel myPanel = new JPanel();
        JLabel myLabel1 = new JLabel("Enter Name");
        JLabel myLabel2 = new JLabel("Enter Longitude");
        JLabel myLabel3 = new JLabel("Enter Latitude");
        JLabel jlblStatus = new JLabel(" ");
        JTextField myText1 = new JTextField(10);
        JTextField myText2 = new JTextField(10);
        JTextField myText3 = new JTextField(10);

        JButton jbtPrint = new JButton("Print");

        public InnerFrame() {

            myPanel.add(myLabel1);
            myPanel.add(myText1);
            myPanel.add(myLabel2);
            myPanel.add(myText2);
            myPanel.add(myLabel3);
            myPanel.add(myText3);

            JPanel p1 = new JPanel(new GridLayout(1,2));
            p1.add(jlblStatus);
            p1.add(jbtPrint);
            jlblStatus.setHorizontalAlignment(SwingConstants.LEFT);
            jlblStatus.setForeground(Color.RED);

            jbtPrint.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        name = myText1.getText();
                        value1 = Double.parseDouble(myText2.getText());
                        value2 = Double.parseDouble(myText3.getText());
                        System.out.println(name);
                        double total = value1 + value2;
                        System.out.println(total);

                        setVisible(false);
                    } catch (NumberFormatException ex) {
                        jlblStatus.setText("Invalid Input");
                    }
                }
            });

            add(myPanel, BorderLayout.CENTER);
            add(p1, BorderLayout.SOUTH);
            setSize(180, 220);
            setLocationRelativeTo(null);
            setVisible(false);

        }
    }
}