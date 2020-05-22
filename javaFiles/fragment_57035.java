import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;

public class MyScrollPane extends JPanel
{

    public MyScrollPane()
    {   
        GridBagConstraints k = new GridBagConstraints();
        k.gridx = 4;
        k.gridy = 5;



        final JTextArea test= new JTextArea(5, 30);
        test.setLineWrap(true);
        test.setWrapStyleWord(true);
        test.setEditable(false);

        JScrollPane spane = new JScrollPane(test);
        spane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        GridBagLayout gbl = new GridBagLayout();
        gbl.setConstraints(spane,k);

        JPanel panel = new JPanel(gbl);     
        panel.add(spane);
        add(panel);

    }


    private static void createAndShowGUI()
    {


        JFrame frame = new JFrame();
        frame.setSize(800, 250);
        frame.setTitle("test1");
        frame.setLocation(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.getContentPane().add(new MyScrollPane());



        frame.setVisible(true);
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run()
            {
                createAndShowGUI();             
            }
        });
    }

}