package test.t100.t001;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import javax.swing.*;

public class TabbedPaneDemo extends JPanel {

    private static final long serialVersionUID = 1L;
    Integer i;

    JTextArea output = new JTextArea();

    public static void main(String args[]) 
    {
        SwingUtilities.invokeLater(new Runnable() {
            public void run()
            {
                JFrame frame = new JFrame("TabbedPaneDemo");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TabbedPaneDemo(), BorderLayout.CENTER);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

    private String getDetails() throws IOException {
        //fn();
        String line;
        String result = "";
        PrintStream p;
        Process p1 = Runtime.getRuntime().exec("tasklist.exe");
        // read from a process
        BufferedReader input = new BufferedReader(
                new InputStreamReader(p1.getInputStream()));
        while ((line = input.readLine()) != null)
        {
            //System.out.println(line);
            output.append(line + "\n");
            result += line+"\n";
            //p.println (line);
            //textarea.setVisible(true);    
        }
        //msgBox(result);
        //p.close();
        input.close();   

        return result;
    }

    public TabbedPaneDemo() {
        super(new GridLayout(1, 1));

        JTabbedPane tabbedPane = new JTabbedPane();
        ImageIcon icon = createImageIcon("images");


        JComponent panel1 = makeTextPanel("tasklist");
        tabbedPane.addTab("tasks", icon, panel1,
                "ta");
        // add it to something!
        panel1.add(new JScrollPane(output));
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

        JComponent panel2 = makeTextPanel("windows");
        tabbedPane.addTab("wins", icon, panel2,
                "wi");
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);


        add(tabbedPane);//`enter code here`
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

        try {
            String s = getDetails();
            output.setText(s);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }


    public static void msgBox(String msg) {
        javax.swing.JOptionPane.showConfirmDialog((java.awt.Component)
                null, msg, "WindowsUtils",
                javax.swing.JOptionPane.DEFAULT_OPTION);
    }


    protected JComponent makeTextPanel(String text)
    {
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);
        return panel;
    }

    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = TabbedPaneDemo.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
}