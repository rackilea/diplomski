import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.event.*;
import javax.swing.GroupLayout.*;

public class HighLightDemo extends JFrame implements DocumentListener {

    private final String[] keywords = {"public", "final", "static"};
    private JScrollPane jScrollPane1;
    private JTextArea textArea;

    final static Color HILIT_COLOR = Color.GREEN;
    final Highlighter hilit;
    final Highlighter.HighlightPainter painter;

    public HighLightDemo() {
        initComponents();
        hilit = new DefaultHighlighter();
        painter = new DefaultHighlighter.DefaultHighlightPainter(HILIT_COLOR);
        textArea.setHighlighter(hilit);
        textArea.getDocument().addDocumentListener(this);
    }

    private void initComponents() {
        textArea = new JTextArea();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("HighlightDemo");

        textArea.setColumns(20);
        textArea.setLineWrap(true);
        textArea.setRows(5);
        textArea.setWrapStyleWord(true);
        jScrollPane1 = new JScrollPane(textArea);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        //Create a parallel group for the horizontal axis
        ParallelGroup hGroup = layout.createParallelGroup(GroupLayout.Alignment.LEADING);

        //Create a sequential and a parallel groups
        SequentialGroup h1 = layout.createSequentialGroup();
        ParallelGroup h2 = layout.createParallelGroup(GroupLayout.Alignment.TRAILING);

        //Add a container gap to the sequential group h1
        h1.addContainerGap();

        //Add a scroll pane and a label to the parallel group h2
        h2.addComponent(jScrollPane1, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE);
        h1.addGroup(h2);

        h1.addContainerGap();

        //Add the group h1 to the hGroup
        hGroup.addGroup(GroupLayout.Alignment.TRAILING, h1);
        //Create the horizontal group
        layout.setHorizontalGroup(hGroup);

        //Create a parallel group for the vertical axis
        ParallelGroup vGroup = layout.createParallelGroup(GroupLayout.Alignment.LEADING);
        //Create a sequential group v1
        SequentialGroup v1 = layout.createSequentialGroup();
        //Add a container gap to the sequential group v1
        v1.addContainerGap();
        //Create a parallel group v2
        ParallelGroup v2 = layout.createParallelGroup(GroupLayout.Alignment.BASELINE);

        //Add the group v2 tp the group v1
        v1.addGroup(v2);
        v1.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED);
        v1.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE);
        v1.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED);
        v1.addContainerGap();

        //Add the group v1 to the group vGroup
        vGroup.addGroup(v1);
        //Create the vertical group
        layout.setVerticalGroup(vGroup);
        pack();
    }

    public void search() {
        hilit.removeAllHighlights();


        for (String s : keywords) {
            String content = textArea.getText();
            Pattern p = Pattern.compile("\\b"+s+"\\b");

            Matcher m = p.matcher(content);
            while (m.find()) {
                int index = m.start();
                int end = index + s.length();
                try {
                    hilit.addHighlight(index, end, painter);
                } catch (BadLocationException ex) {
                }

            }
        }

    }

    @Override
    public void insertUpdate(DocumentEvent ev) {
        search();
    }

    @Override
    public void removeUpdate(DocumentEvent ev) {
        search();
    }

    @Override
    public void changedUpdate(DocumentEvent ev) {
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new HighLightDemo().setVisible(true);
            }
        });
    }

}