import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.plaf.basic.*;

public class FileChooserSave
{
    public static void main(String[] args)
    {
        final JFileChooser chooser = new JFileChooser( new File(".") )
        {
            public void approveSelection()
            {
                if (getSelectedFile().exists())
                {
                    super.approveSelection();
                }
                else
                    System.out.println("File doesn't exist");
            }
        };

        chooser.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                System.out.println(e);
            }
        });

        chooser.setSelectedFile( new File("something.txt") );
        int returnVal = chooser.showSaveDialog(null);


        if(returnVal == JFileChooser.APPROVE_OPTION)
        {
           System.out.println(chooser.getSelectedFile() );
        }

    }
}