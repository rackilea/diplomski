import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.event.*;
import javax.swing.GroupLayout.*;


public class Stringtext extends JFrame
                       implements DocumentListener {

private JTextField entry;
private JLabel jLabel1;
private JScrollPane jScrollPane1;
private JLabel status;
private JTextArea textArea;

final static Color  HILIT_COLOR = Color.YELLOW;
final static Color  ERROR_COLOR = Color.PINK;
final static String CANCEL_ACTION = "cancel-search";

final Color entryBg;
final Highlighter hilit;
final Highlighter.HighlightPainter painter;


public Stringtext() {
    initComponents();
  /*code to put text from a file
    InputStream in = getClass().getResourceAsStream("file2.txt");
    try {
        textArea.read(new InputStreamReader(in), null);
    } catch (IOException e) {
        e.printStackTrace();
    }
  */
    textArea.setText("hello Mr! please try to post an SSCCE next time otherwise don't you DARE to...");
    hilit = new DefaultHighlighter();
    painter = new DefaultHighlighter.DefaultHighlightPainter(HILIT_COLOR);
    textArea.setHighlighter(hilit);

    entryBg = entry.getBackground();
    entry.getDocument().addDocumentListener(this);

    InputMap im = entry.getInputMap(JComponent.WHEN_FOCUSED);
    ActionMap am = entry.getActionMap();
    im.put(KeyStroke.getKeyStroke("ESCAPE"), CANCEL_ACTION);
    am.put(CANCEL_ACTION, new CancelAction()); 

    }


  private void initComponents() {
    entry = new JTextField();
    textArea = new JTextArea();
    status = new JLabel();
    jLabel1 = new JLabel();

    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setTitle("TextFieldDemo");

    textArea.setColumns(20);
    textArea.setLineWrap(true);
    textArea.setRows(5);
    textArea.setWrapStyleWord(true);
    textArea.setEditable(true);
    jScrollPane1 = new JScrollPane(textArea);

    jLabel1.setText("Enter text to search:");

    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);

ParallelGroup hGroup = layout.createParallelGroup(GroupLayout.Alignment.LEADING);
SequentialGroup h1 = layout.createSequentialGroup();
ParallelGroup h2 = layout.createParallelGroup(GroupLayout.Alignment.CENTER);

h1.addContainerGap();

h2.addComponent(jScrollPane1, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE);
h2.addComponent(status, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE);

SequentialGroup h3 = layout.createSequentialGroup();
h3.addComponent(jLabel1);
h3.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED);
h3.addComponent(entry, GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE);

h2.addGroup(h3);

h1.addGroup(h2);

h1.addContainerGap();

hGroup.addGroup(GroupLayout.Alignment.TRAILING, h1);

layout.setHorizontalGroup(hGroup);



ParallelGroup vGroup = layout.createParallelGroup(GroupLayout.Alignment.LEADING);

SequentialGroup v1 = layout.createSequentialGroup();

v1.addContainerGap();

ParallelGroup v2 = layout.createParallelGroup(GroupLayout.Alignment.BASELINE);
v2.addComponent(jLabel1);
v2.addComponent(entry, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE);

v1.addGroup(v2);
v1.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED);
v1.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE);
v1.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED);
v1.addComponent(status);
v1.addContainerGap();

//Add the group v1 to the group vGroup
vGroup.addGroup(v1);
//Create the vertical group
layout.setVerticalGroup(vGroup);
pack();
   }

   public void search() {
    hilit.removeAllHighlights();

    String s = entry.getText();

    if (s.length() <= 0) {
        message("Nothing to search");
        return;
      }

    String content = textArea.getText();

    int index = content.indexOf(s, 0);
    if (index >= 0) {   // match found
        try {
            int end = index + s.length();
            hilit.addHighlight(index, end, painter);
            textArea.setCaretPosition(end);
            entry.setBackground(entryBg);
            message("'" + s + "' found. Press ESC to end search");
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    } else {
        entry.setBackground(ERROR_COLOR);
        message("'" + s + "' not found. Press ESC to start a new search");
    }
   }

  void message(String msg) {
    status.setText(msg);
   }

   public void insertUpdate(DocumentEvent ev) {
    search();
   }

  public void removeUpdate(DocumentEvent ev) {
    search();
   }

   public void changedUpdate(DocumentEvent ev) {
   }

  class CancelAction extends AbstractAction {
    public void actionPerformed(ActionEvent ev) {
        hilit.removeAllHighlights();

        entry.setText("boo");
        entry.setBackground(entryBg);
    }
   }


   public static void main(String args[]) {

SwingUtilities.invokeLater(new Runnable() {
        public void run() {

            UIManager.put("swing.boldMetal", Boolean.FALSE);
    new Stringtext().setVisible(true);
        }
    });
   }
  }