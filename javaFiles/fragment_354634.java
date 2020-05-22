import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.text.*;

class TextAreaLoad
{
    private static void createAndShowGUI()
    {
        final JTextArea edit = new JTextArea(30, 60);

        JButton read = new JButton("Read TextAreaLoad.txt");
        read.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    FileInputStream fis = new FileInputStream( "TextAreaLoad.txt" );
                    InputStreamReader reader = new InputStreamReader(fis);
                    BufferedReader br = new BufferedReader(reader);
                    edit.read( br, null );
                    br.close();
                    edit.requestFocus();
                }
                catch(Exception e2) { System.out.println(e2); }
            }
        });
        JFrame frame = new JFrame("TextArea Load");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add( new JScrollPane(edit), BorderLayout.NORTH );
        frame.add(read, BorderLayout.SOUTH);
        frame.pack();
        frame.setLocationRelativeTo( null );
        frame.setVisible(true);
    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                createAndShowGUI();
            }
        });
    }
}