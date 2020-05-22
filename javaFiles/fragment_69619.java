import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class ListDemo extends JFrame {

  DefaultListModel listModel = new DefaultListModel();
  JList list = new JList(listModel);
  JScrollPane listScrollPane = new JScrollPane(list);
  JPanel buttonPanel = new JPanel(new FlowLayout());
  JPanel centerPanel = new JPanel(new GridLayout(1, 0));
  JTextArea textArea = new JTextArea();
  JScrollPane textAreaScrollPane = new JScrollPane(textArea);
  JTextField pathTextField = new JTextField();
  JButton findButton = new JButton("Find");

  /**
   * Original implementation of "find" from question.
   * 
   * @param lists
   * @param dir 
   */
  public static void find(Map<String, List<String>> lists, File dir) {
    for (File f : dir.listFiles()) {
      if (f.isDirectory()) {
        find(lists, f);
      } else {
        String hash = f.getName() + f.length();
        List<String> list = lists.get(hash);
        if (list == null) {

          // Create a linked listScrollPane and add duplicate entries
          list = new LinkedList<String>();
          lists.put(hash, list);
        }
        list.add(f.getAbsolutePath());
      }
    }
  }

  public void doFind() {
    String path = pathTextField.getText();
    if (path == null || path.isEmpty()) {
      return;
    }
    File file = new File(path);
    if (!(file.exists() && file.isDirectory())) {
      JOptionPane.showMessageDialog(this, "Not a valid path.");
      return;
    }

    Map<String, List<String>> lists = new HashMap<String, List<String>>();

    // Populate list model
    listModel.clear();
    find(lists, file);
    for (List<String> list : lists.values()) {
      if (list.size() > 1) {
        listModel.addElement("--");
        listModel.addElement("Duplicates Found");
        for (String file1 : list) {
          listModel.addElement(file1);
        }
      }
    }
    listModel.addElement("--");

    // Populate text area
    StringBuilder sb = new StringBuilder();
    find(lists, file);
    for (List<String> list : lists.values()) {
      if (list.size() > 1) {
        sb.append("--\n");
        sb.append("Duplicates Found\n");
        for (String file1 : list) {
          sb.append(file1);
          sb.append("\n");
        }
      }
    }
    sb.append("--\n");
    textArea.setText(sb.toString());   
  }

  public ListDemo() {
    setTitle("List Demo");
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setSize(new Dimension(500, 500));
    centerPanel.add(listScrollPane);
    centerPanel.add(textAreaScrollPane);
    add(centerPanel, BorderLayout.CENTER);
    pathTextField.setColumns(30);
    buttonPanel.add(pathTextField);
    buttonPanel.add(findButton);
    add(buttonPanel, BorderLayout.SOUTH);
    findButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        doFind();
      }
    });
  }

  public static final void main(String[] args) {
    // Run in GUI thread
    Runnable runnable = new Runnable() {
      @Override
      public void run() {
        ListDemo frame = new ListDemo();
        // Center in screen and show
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
        frame.setVisible(true);
      }
    };
    SwingUtilities.invokeLater(runnable);
  }
}