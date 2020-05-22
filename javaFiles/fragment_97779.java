import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

class LabelProblem
{

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                initGUI();
            }
        });
    }

    public static void initGUI()
    {

        JFrame frame = new JFrame("Label Problem");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));

        JPanel componentPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel label = new JLabel("Sample Text");
        label.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        componentPanel.add(label);

        JTabbedPane Tab = new JTabbedPane();
        Tab.add("Document 1", new JPanel());

        main.add(Tab);
        main.add(componentPanel);

        JTextArea area = new JTextArea(10, 10);
        JScrollPane scroll = new JScrollPane(area);

        frame.add(main);
        frame.add(scroll, BorderLayout.SOUTH);
        frame.setSize(450, 450);
        frame.setVisible(true);
    }
}