import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class DemoMenu extends JFrame {

//    Frame frm = new Frame();
    JMenuBar bar = new JMenuBar();
    //frm.setJMenuBar(bar);
    JMenu mf = new JMenu("File");
    JMenu me = new JMenu("Edit");
    JMenu mfo = new JMenu("Format");
    JMenu mv = new JMenu("View");
    JMenu mh = new JMenu("Help");
    JMenuItem mf1 = new JMenuItem("New" + "     " + "Ctrl+N");
    JMenuItem mf2 = new JMenuItem("Open..." + "     " + "Ctrl+O");
    JMenuItem mf3 = new JMenuItem("Save" + "     " + "Ctrl+S");
    JMenuItem mf4 = new JMenuItem("Save As...");
    JMenuItem mf5 = new JMenuItem("Page Setup...");
    JMenuItem mf6 = new JMenuItem("Print..." + "     " + "Ctrl+P");
    JMenuItem mf7 = new JMenuItem("Exit");
    JMenuItem me1 = new JMenuItem("Undo" + "     " + "Ctrl+Z");
    JMenuItem me2 = new JMenuItem("Cut" + "     " + "Ctrl+X");
    JMenuItem me3 = new JMenuItem("Copy" + "     " + "Ctrl+C");
    JMenuItem me4 = new JMenuItem("Paste" + "     " + "Ctrl+V");
    JMenuItem me5 = new JMenuItem("Delete" + "     " + "Del");
    JMenuItem me6 = new JMenuItem("Find..." + "     " + "Ctrl+F");
    JMenuItem me7 = new JMenuItem("Find Next" + "     " + "F3");
    JMenuItem me8 = new JMenuItem("Replace..." + "     " + "Ctrl+H");
    JMenuItem me9 = new JMenuItem("Go To" + "     " + "Ctrl+G");
    JMenuItem me10 = new JMenuItem("Select All" + "     " + "Ctrl+A");
    JMenuItem me11 = new JMenuItem("Date/Time" + "     " + "F5");
    JMenuItem mfo1 = new JMenuItem("Word Wrap");
    JMenuItem mfo2 = new JMenuItem("Font...");
    JMenuItem mv1 = new JMenuItem("Status Bar");
    JMenuItem mh1 = new JMenuItem("Help Topics");
    JMenuItem mh2 = new JMenuItem("About Notepad");

    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                DemoMenu dm = new DemoMenu();
            }
        });

    }

    public DemoMenu() {
        super("United- Notepad");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setJMenuBar(bar);
        bar.add(mf);
        bar.add(me);
        bar.add(mfo);
        bar.add(mv);
        bar.add(mh);

        mf.add(mf1);
        mf.add(mf2);
        mf.add(mf3);
        mf.add(mf4);
        mf.addSeparator();
        mf.add(mf5);
        mf.add(mf6);
        mf.addSeparator();
        mf.add(mf7);


        mf1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane smd = new JOptionPane();
                smd.showMessageDialog(null, "Press Ok to open new page");

            }
        });

        final JTextArea jta = new JTextArea(10, 20);
        JScrollPane scrl = new JScrollPane(jta);
        add(scrl);

        mf2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                JFileChooser chooser = new JFileChooser();
                int selection = chooser.showOpenDialog(DemoMenu.this);
                if (selection == JFileChooser.APPROVE_OPTION) {

                    JOptionPane.showMessageDialog(null, "so u want to open the file...");
                    File file = chooser.getSelectedFile();
                    FileInputStream fis = null;
                    try {
                        fis = new FileInputStream(file);
                        byte b[] = new byte[fis.available()];
                        fis.read(b);
                        String str = new String(b);
                        jta.setText(str);
                    } catch (Exception f) {
                        f.printStackTrace();
                    } finally {
                        try {
                            fis.close();
                        } catch (Exception exp) {
                        }
                    }
                }
            }
        });

        mf3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                chooser.showSaveDialog(null);
            }
        });


        mf4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                chooser.showDialog(null, "Save As");
            }
        });

        mf7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane scd = new JOptionPane();
                scd.showConfirmDialog(null, "Are you want to exit");
            }
        });
        me.add(me1);
        me.addSeparator();
        me.add(me2);
        me.add(me3);
        me.add(me4);
        me.add(me5);
        me.addSeparator();
        me.add(me6);
        me.add(me7);
        me.add(me8);
        me.add(me9);
        me.addSeparator();
        me.add(me10);
        me.add(me11);
        me11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Date d1 = new Date();
                JOptionPane smddate = new JOptionPane();
                smddate.showMessageDialog(null, d1);

            }
        });

        mfo.add(mfo1);
        mfo.add(mfo2);

        mv.add(mv1);

        mh.add(mh1);
        mh.addSeparator();
        mh.add(mh2);

        setSize(520, 540);
        setVisible(true);
    }
}