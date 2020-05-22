import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class MyFileChooser extends JPanel implements ActionListener
{
    JButton saveButton;
    JTextArea content;
    JFileChooser jfc;

    private boolean docUpdate = false;
    private String default_filename = "default.txt";
    private String default_directory = "/home/foo/workspace";
    private int version = 0; 

    public MyFileChooser()
    {
        super(new BorderLayout());

        content = new JTextArea(5, 20);
        content.setMargin(new Insets(5, 5, 5, 5));
        content.getDocument().addDocumentListener(new DocumentListener()
        {

            @Override
            public void removeUpdate(DocumentEvent e)
            {
                System.out.println("remove update");
                docUpdate = true;               
            }

            @Override
            public void insertUpdate(DocumentEvent e)
            {
                System.out.println("insert update");
                docUpdate = true;
            }

            @Override
            public void changedUpdate(DocumentEvent e)
            {
                System.out.println("changed update");
                docUpdate = true;               
            }
        });
        JScrollPane logScrollPane = new JScrollPane(content);

        jfc = new JFileChooser();

        /**
         * Set a initial default directory and a initial default filename here. 
         */
        //fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        jfc.setCurrentDirectory(new File(default_directory));
        jfc.setSelectedFile(new File(default_filename));
        jfc.addPropertyChangeListener(new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent evt)
            {               
                if (docUpdate == true)
                {
                    /**
                     * User can use the suggested filename or remove the suggested,
                     * and enter a new filename.
                     * Here, we set to a new directory and of cause, user can select
                     * what is the directory he want.
                     */
                    jfc.setCurrentDirectory(new File("/home/foo"));
                    jfc.setSelectedFile(new File("default" + version + ".txt"));
                }               
            }
        });

        saveButton = new JButton("Save a File...");
        saveButton.addActionListener(this);

        JPanel buttonPanel = new JPanel(); 
        buttonPanel.add(saveButton);

        add(buttonPanel, BorderLayout.PAGE_START);
        add(logScrollPane, BorderLayout.CENTER);        
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {

        int returnVal = jfc.showSaveDialog(MyFileChooser.this);
        if (returnVal == JFileChooser.APPROVE_OPTION)
        {
            File file = jfc.getSelectedFile();
            // save the file.
            BufferedWriter bw;
            try {
                bw = new BufferedWriter(new FileWriter(file));
                bw.write(content.getText());
                bw.flush();
            }               
            catch (IOException e1)
            {
                e1.printStackTrace();
            }
            version++;

        }
        else
        {
            System.out.println("Save command cancelled by user. ");
        }
        content.setCaretPosition(content.getDocument().getLength());

    }

    private static void createAndShowGUI()
    {       
        JFrame frame = new JFrame("FileChooserDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(new MyFileChooser());

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {

            @Override
            public void run() 
            {
                createAndShowGUI();             
            }
        });
    }

}