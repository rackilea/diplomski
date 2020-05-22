import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import java.util.Arrays;

public class Online extends JFrame {

    static JRadioButton[] choice = new JRadioButton[6];
    JFrame jtfMainFrame, jtfMainFrame1;

    public void createWindow() {

        jtfMainFrame = new JFrame("Online Examination");
    jtfMainFrame.setSize(800, 500);
    jtfMainFrame.setLocation(200, 150);
    jtfMainFrame.addWindowListener(new WindowAdapter() {

        @Override
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    });
    JPanel pa = new JPanel();

    //JPanel panlabels = new JPanel(new GridLayout(0, 1, 0, 60));

    JPanel pancontrols = new JPanel(new GridLayout(0, 2, 0, 60));
    JPanel panEast = new JPanel();

    JPanel pan = new JPanel(new BorderLayout());
    JLabel qLabel = new JLabel("Question.");
    qLabel.setOpaque(true);
    qLabel.setForeground(Color.blue);
    qLabel.setBackground(Color.lightGray);

    JLabel aLabel = new JLabel("Question.");
    aLabel.setOpaque(true);
    aLabel.setForeground(Color.blue);
    aLabel.setBackground(Color.lightGray);

    JLabel bLabel = new JLabel("a.");
    bLabel.setOpaque(true);
    bLabel.setForeground(Color.blue);
    bLabel.setBackground(Color.lightGray);

    JLabel cLabel = new JLabel("b.");
    cLabel.setOpaque(true);
    cLabel.setForeground(Color.blue);
    cLabel.setBackground(Color.lightGray);

    JLabel dLabel = new JLabel("c.");
    dLabel.setOpaque(true);
    dLabel.setForeground(Color.blue);
    dLabel.setBackground(Color.lightGray);

    JLabel eLabel = new JLabel("d.");
    eLabel.setOpaque(true);
    eLabel.setForeground(Color.blue);
    eLabel.setBackground(Color.lightGray);


    //panlabels.add(fLabel, BorderLayout.WEST);
    //fLabel.setVisible(false);

    JLabel ques = new JLabel("q");
    ques.setBackground(Color.red);

    choice[1] = new JRadioButton("a");
    choice[1].setBackground(Color.red);

    choice[2] = new JRadioButton("b");
    choice[2].setBackground(Color.red);

    choice[3] = new JRadioButton("c");
    choice[3].setBackground(Color.red);

    choice[4] = new JRadioButton("d");
    choice[4].setBackground(Color.red);

    ButtonGroup bGroup = new ButtonGroup();
    //pancontrols.add(new JLabel(""));
    pancontrols.add(ques, BorderLayout.WEST);
    for (int i = 1; i < 5; i++) {
        // pancontrols.add(aLabel,BorderLayout.WEST);
        bGroup.add(choice[i]);

    }

    pancontrols.add(qLabel);
    pancontrols.add(ques);

    pancontrols.add(bLabel);
    pancontrols.add(choice[1]);
    pancontrols.add(cLabel);
    pancontrols.add(choice[2]);
    pancontrols.add(dLabel);
    pancontrols.add(choice[3]);
    pancontrols.add(eLabel);
    pancontrols.add(choice[4]);
    pancontrols.setSize(400,200);
    choice[4].setVisible(true);
    pa.add(pancontrols);
    pa.setBorder(BorderFactory.createTitledBorder(
        BorderFactory.createEtchedBorder(), "Select your answer"));

    //getContentPane().add(label);
    //to be deleted pa.add("South", pan);
        pa.setBackground(Color.pink);
        jtfMainFrame.add(pa);
        jtfMainFrame.setExtendedState(Frame.MAXIMIZED_BOTH);

        jtfMainFrame.setVisible(true);
    }

    public static void main(String[] args) {
        Online r = new Online();
        r.createWindow();
    }
}