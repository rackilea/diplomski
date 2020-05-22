import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;

public class Test extends JFrame {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }
                Test test = new Test();
                test.runGui();
            }
        });
    }

    int ctr = 0, top = 5;

    public List<JPanel> o_panels = new ArrayList<JPanel>(); //Your List

    public Test() {
        super("MCC");
        //Output panel for the results
        JPanel outpanel = new JPanel();
        outpanel.setBackground(Color.blue);
        outpanel.setVisible(true);
        outpanel.setLayout(new BoxLayout(outpanel, BoxLayout.PAGE_AXIS));

        //Scroll pane
        JScrollPane scrollPane = new JScrollPane(outpanel,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        scrollPane.setBounds(0, 0, 780, 400);
        add(scrollPane);

    //result panel
        //creating and adding panels in to the array list
        while (ctr <= 4) {
            JPanel label1 = new JPanel();
            label1.setPreferredSize(new Dimension(600, 100));
            label1.setBorder(new LineBorder(Color.RED));
            o_panels.add(label1);
            outpanel.add(o_panels.get(ctr));
            ctr++;
        }
    }

    public void runGui() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        this.setVisible(true);
//        this.setResizable(false);
        setLocationRelativeTo(null);
    }
}