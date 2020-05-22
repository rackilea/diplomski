import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class ClassChooser extends JFrame implements ActionListener {
   // create a label
   private JLabel           response;
   File                 file;
   // menu tabs
   private JMenu            fileMenu;
   private JMenu            editMenu;
   private JMenu            helpMenu;
   String                   line;
   // create a file chooser
   private JFileChooser fc = null; 
   BufferedReader           br;
   // create a text area
   JTextArea                ta  = new JTextArea();
     private String currentFileBeingEdited = null;
   // constructors
   public ClassChooser() {
       // create scroll pane
       JScrollPane scrollPane = new JScrollPane(ta);
       ta.setText("Enter text to see scroll bars.");
       // create a panel
       JPanel content = new JPanel();
       content.setLayout(new BorderLayout());
       content.add(scrollPane, BorderLayout.CENTER);
       // call functions to create drop down menu's
       createFileMenu();
       createEditMenu();
       createHelpMenu();
       // create menu bar and add drop down menu's
       JMenuBar menuBar = new JMenuBar();
       this.setJMenuBar(menuBar);
       menuBar.add(fileMenu);
       menuBar.add(editMenu);
       menuBar.add(helpMenu);
       this.setContentPane(content);
       this.setTitle("File Chooser");
       this.setVisible(true);
       this.setSize(600, 250);
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 }

 public void createFileMenu() {
       JMenuItem item;
       fileMenu = new JMenu("File");
       item = new JMenuItem("New");
       item.addActionListener(this);
       fileMenu.add(item);
       item = new JMenuItem("Open");
       item.addActionListener(new OpenListener());
       fileMenu.add(item);
       item = new JMenuItem("Save");
       item.addActionListener(this);
       fileMenu.add(item);
       item = new JMenuItem("Rename");
       item.addActionListener(this);
       fileMenu.add(item);
       item = new JMenuItem("Delete");
       item.addActionListener(this);
       fileMenu.add(item);
       item = new JMenuItem("Make Directory");
       item.addActionListener(this);
       fileMenu.add(item);
       fileMenu.addSeparator();
       item = new JMenuItem("Exit");
       item.addActionListener(this);
       fileMenu.add(item);
 }

 public void createEditMenu() {
       JMenuItem item;
       editMenu = new JMenu("Edit");
       item = new JMenuItem("Cut");
       item.addActionListener(this);
       editMenu.add(item);
       item = new JMenuItem("Copy");
       item.addActionListener(this);
       editMenu.add(item);
       item = new JMenuItem("Paste");
       item.addActionListener(this);
       editMenu.add(item);
 }

public void createHelpMenu() {
    JMenuItem item;
    helpMenu = new JMenu("Help");
    item = new JMenuItem("Welcome");
    item.addActionListener(this);
    helpMenu.add(item);
    item = new JMenuItem("Help Contents");
    item.addActionListener(this);
    helpMenu.add(item);
    }

private class OpenListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        //ADDED ONLY THIS LINE
        ta.setText("");
        fc = new JFileChooser();
        // directories only to be selected
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fc.setSelectedFile(fc.getCurrentDirectory());
        fc.setDialogTitle("Directory Chooser");
        fc.setMultiSelectionEnabled(false);

        int retVal = fc.showOpenDialog(ClassChooser.this);
        // File file;

        if (retVal == fc.APPROVE_OPTION) {
            file = fc.getSelectedFile();
            currentFileBeingEdited = file.getAbsolutePath();
            try {
                br = new BufferedReader(new FileReader(file));
            } catch (FileNotFoundException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            try {
                line = br.readLine();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            while (line != null) {
                ta.append(line + "\n");
                try {
                    line = br.readLine();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        }

    }
}

public static void main(String[] args) {
    ClassChooser fce = new ClassChooser();
    String filename = File.separator + "tmp";

}

public void actionPerformed(ActionEvent e) {
    // TODO Auto-generated method stub
    String menuName;

    menuName = e.getActionCommand();

    if (menuName.equals("Exit")) {
        System.exit(0);
    } else if("Save".equalsIgnoreCase(menuName)){
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new File(currentFileBeingEdited));
            pw.println(ta.getText());
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } finally {
            if(pw != null){
                pw.close();
            }
        }

    } else {
        response.setText("Menu Item '" + menuName + "' is selected.");
    }
}

}