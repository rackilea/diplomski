//Works fine for me on Windows 7 x64 using JDK 1.7.0_60:
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;
import javax.swing.undo.*;

public final class UndoManagerTest {
  private final JTextField textField0 = new JTextField("default");
  private final JTextField textField1 = new JTextField();
  private final UndoManager undoManager0 = new UndoManager();
  private final UndoManager undoManager1 = new UndoManager();

  public JComponent makeUI() {
    textField1.setDocument(new CustomUndoPlainDocument());
    textField1.setText("aaaaaaaaaaaaaaaaaaaaa");

    textField0.getDocument().addUndoableEditListener(undoManager0);
    textField1.getDocument().addUndoableEditListener(undoManager1);

    JPanel p = new JPanel();
    p.add(new JButton(new AbstractAction("undo") {
      @Override public void actionPerformed(ActionEvent e) {
        if (undoManager0.canUndo()) {
          undoManager0.undo();
        }
        if (undoManager1.canUndo()) {
          undoManager1.undo();
        }
      }
    }));
    p.add(new JButton(new AbstractAction("redo") {
      @Override public void actionPerformed(ActionEvent e) {
        if (undoManager0.canRedo()) {
          undoManager0.redo();
        }
        if (undoManager1.canRedo()) {
          undoManager1.redo();
        }
      }
    }));
    p.add(new JButton(new AbstractAction("setText(new Date())") {
      @Override public void actionPerformed(ActionEvent e) {
        String str = new Date().toString();
        textField0.setText(str);
        textField1.setText(str);
      }
    }));

    Box box = Box.createVerticalBox();
    box.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    box.add(makePanel("Default", textField0));
    box.add(Box.createVerticalStrut(5));
    box.add(makePanel("replace ignoring undo", textField1));

    JPanel pp = new JPanel(new BorderLayout());
    pp.add(box, BorderLayout.NORTH);
    pp.add(p, BorderLayout.SOUTH);
    return pp;
  }
  private static JPanel makePanel(String title, JComponent c) {
    JPanel p = new JPanel(new BorderLayout());
    p.setBorder(BorderFactory.createTitledBorder(title));
    p.add(c);
    return p;
  }
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      @Override public void run() {
        createAndShowGUI();
      }
    });
  }
  public static void createAndShowGUI() {
    JFrame f = new JFrame();
    f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    f.getContentPane().add(new UndoManagerTest().makeUI());
    f.setSize(320, 240);
    f.setLocationRelativeTo(null);
    f.setVisible(true);
  }
}

class CustomUndoPlainDocument extends PlainDocument {
  private CompoundEdit compoundEdit;
  @Override protected void fireUndoableEditUpdate(UndoableEditEvent e) {
    if (compoundEdit == null) {
      super.fireUndoableEditUpdate(e);
    } else {
      compoundEdit.addEdit(e.getEdit());
    }
  }
  @Override public void replace(
      int offset, int length,
      String text, AttributeSet attrs) throws BadLocationException {
    if (length == 0) {
      System.out.println("insert");
      super.replace(offset, length, text, attrs);
    } else {
      System.out.println("replace");
      compoundEdit = new CompoundEdit();
      super.fireUndoableEditUpdate(new UndoableEditEvent(this, compoundEdit));
      super.replace(offset, length, text, attrs);
      compoundEdit.end();
      compoundEdit = null;
    }
  }
}