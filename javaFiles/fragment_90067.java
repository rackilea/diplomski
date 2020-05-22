import java.awt.Font;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

@SuppressWarnings("serial")
public class Notepad extends JFrame
{
    public static void main(String args[])
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                try
                {
                    UIManager.setLookAndFeel(
                            "javax.swing.plaf.nimbus.NimbusLookAndFeel");
                }
                catch (ClassNotFoundException | InstantiationException
                        | IllegalAccessException
                        | UnsupportedLookAndFeelException e)
                {
                    e.printStackTrace();
                }
                new Notepad();
            }
        });
    }

    private JTextArea textArea = new JTextArea("", 0, 0);
    private JMenuBar menuBar = new JMenuBar();
    private JMenu file = new JMenu();
    private JMenuItem openFile = new JMenuItem();
    private JMenuItem saveFile = new JMenuItem();
    private JMenuItem close = new JMenuItem();
    private JFileChooser open, save;

    public Notepad()
    {
        setBounds(100, 100, 700, 500);
        setTitle("Projet Java");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        textArea.setFont(new Font("Helvetica", Font.ROMAN_BASELINE, 12));
        add(new JScrollPane(textArea));

        open = new JFileChooser();
        save = new JFileChooser();

        setJMenuBar(menuBar);
        menuBar.add(file);
        file.setText("File");

        openFile.setText("Open");
        openFile.addActionListener(e -> {
            if (open.showOpenDialog(
                    Notepad.this) == JFileChooser.APPROVE_OPTION)
            {
                textArea.setText("");
                try (BufferedReader br = new BufferedReader(
                        new FileReader(open.getSelectedFile())))
                {
                    String s = null;
                    while ((s = br.readLine()) != null)
                    {
                        textArea.append(s + "\n");
                    }
                }
                catch (Exception ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
        });
        file.add(openFile);

        saveFile.setText("Save");
        saveFile.addActionListener(e -> {
            if (save.showSaveDialog(
                    Notepad.this) == JFileChooser.APPROVE_OPTION)
            {
                try (BufferedWriter out = new BufferedWriter(
                        new FileWriter(save.getSelectedFile())))
                {
                    out.write(textArea.getText());
                }
                catch (Exception ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
        });
        file.add(saveFile);

        close.setText("Close");
        close.addActionListener(e -> {
            System.exit(0);
        });
        file.add(close);

        setVisible(true);
    }
}