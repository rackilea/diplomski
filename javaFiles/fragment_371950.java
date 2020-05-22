import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

public class Example extends JFrame{

    private JTextPane pane;
    public Example(){
        init();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    private void init() {
        JScrollPane p = new  JScrollPane(pane = new JTextPane());
        add(p);
        List<String> files = new ArrayList<>();
        files.add("1.txt");
        files.add("2.txt");
        files.add("3.doc");
        files.add("4.xls");
        for(String s : files){
            addText(s);
        }
    }

    private void addText(String s) {
        Color color = getColor(s);
        StyleContext style = StyleContext.getDefaultStyleContext();
        AttributeSet attrs = style.addAttribute(SimpleAttributeSet.EMPTY,StyleConstants.Foreground, color);
        pane.setCaretPosition(pane.getDocument().getLength());
        pane.setCharacterAttributes(attrs , false);
        pane.replaceSelection(s+"\n");
    }

    private Color getColor(String s) {
        return  s.endsWith(".txt") ? Color.RED : (s.endsWith(".doc") ? Color.GREEN : Color.CYAN );
    }

    public static void main(String... s){
        new Example();
    }
}