package com.ggl.testing;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

public class JTextPaneTest implements Runnable {

    private JTextPane textPane;

    private StyledDocument styledDocument;

    public static void main(String[] args) throws BadLocationException {
        SwingUtilities.invokeLater(new JTextPaneTest());
    }

    public JTextPaneTest() throws BadLocationException {
        this.styledDocument = new DefaultStyledDocument();
        this.styledDocument.insertString(0, displayText(), null);
        addStylesToDocument(styledDocument);
    }

    @Override
    public void run() {
        JFrame frame = new JFrame("JTextPane Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);

        textPane = new JTextPane(styledDocument);
        textPane.addCaretListener(new SelectedText());
        textPane.setPreferredSize(new Dimension(250, 125));
        JScrollPane scrollPane = new JScrollPane(textPane);

        frame.add(scrollPane);
        frame.pack();
        frame.setVisible(true);
    }

    private String displayText() {
        return "This is some sample text.  Pick part of the text to select "
                + "by double clicking on a word.";
    }

    private void addStylesToDocument(StyledDocument styledDocument) {
        Style def = StyleContext.getDefaultStyleContext().getStyle(
                StyleContext.DEFAULT_STYLE);
        Style s = styledDocument.addStyle("bold", def);
        StyleConstants.setBold(s, true);
    }

    private class SelectedText implements CaretListener {

        @Override
        public void caretUpdate(CaretEvent event) {
            int dot = event.getDot();
            int mark = event.getMark();
            if (dot != mark) {
                if (dot < mark) {
                    int temp = dot;
                    dot = mark;
                    mark = temp;
                }
                boldSelectedText(mark, dot);
            }
        }

        private void boldSelectedText(int mark, int dot) {
            try {
                int length = dot - mark;
                String s = styledDocument.getText(mark, length);
                styledDocument.remove(mark, length);
                styledDocument.insertString(mark, s,
                        styledDocument.getStyle("bold"));
            } catch (BadLocationException e) {
                e.printStackTrace();
            }
        }

    }

}