import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TextEditor implements ActionListener {
    JFrame frame;
    JTextArea textArea;
    JScrollPane scrollPane;
    JMenuBar menuBar;

    public TextEditor() {
        frame = new JFrame("Note Pad");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("image.gif"));

        textArea = new JTextArea(500, 500);
        scrollPane = new JScrollPane(textArea);

        menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");

        JMenuItem newItem = new JMenuItem("New");
        JMenuItem open = new JMenuItem("Open");
        JMenuItem save = new JMenuItem("Save");
        JMenuItem close = new JMenuItem("Close");

        JMenuItem cut = new JMenuItem("Cut");
        JMenuItem copy = new JMenuItem("Copy");
        JMenuItem paste = new JMenuItem("Paste");
        JMenuItem delete = new JMenuItem("Delete");

        newItem.addActionListener(this);
        open.addActionListener(this);
        save.addActionListener(this);
        close.addActionListener(this);

        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        delete.addActionListener(this);

        fileMenu.add(newItem);
        fileMenu.add(open);
        fileMenu.add(save);
        fileMenu.add(close);

        editMenu.add(cut);
        editMenu.add(copy);
        editMenu.add(paste);
        editMenu.add(delete);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);

        frame.setJMenuBar(menuBar);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Very important!
        frame.pack();

        // Sheesh!  You kids and your enormous screens!
        //frame.setSize(1000, 1000);
        frame.setSize(600, 400);
    }

    public static void main(String[] args) {
        // Always a good idea.
        Runnable r = new Runnable() {
            public void run() {
                TextEditor te = new TextEditor();
            }
        };
        SwingUtilities.invokeLater(r);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==menuBar.getMenu(0).getMenuComponent(0)) {
            JFrame frame2=new JFrame();
            frame2.setSize(300,300);
            frame2.setVisible(true);
            frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }
}