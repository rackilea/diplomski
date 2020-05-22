import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.undo.*;
import javax.swing.event.*;

public class ReplaceUndoableEditDemo {
  private final UndoManager um = new UndoManager();
  private final JTextField tf = new JTextField(24);
  private final UndoManager undoManager = new UndoManager();
  private final JTextField field = new JTextField(24);
  private final Document doc = new PlainDocument() {
    @Override public void replace(
      int offset, int length, String text, AttributeSet attrs)
    throws BadLocationException {
      undoManager.undoableEditHappened(new UndoableEditEvent(
          this, new ReplaceUndoableEdit(offset, length, text)));
      replaceIgnoringUndo(offset, length, text, attrs);
    }
    private void replaceIgnoringUndo(
      int offset, int length, String text, AttributeSet attrs)
    throws BadLocationException {
      for(UndoableEditListener uel: getUndoableEditListeners()) {
        removeUndoableEditListener(uel);
      }
      super.replace(offset, length, text, attrs);
      for(UndoableEditListener uel: getUndoableEditListeners()) {
        addUndoableEditListener(uel);
      }
    }
    class ReplaceUndoableEdit extends AbstractUndoableEdit {
      private final String oldValue;
      private final String newValue;
      private int offset;
      public ReplaceUndoableEdit(int offset, int length, String newValue) {
        String txt;
        try {
          txt = getText(offset, length);
        } catch(BadLocationException e) {
          txt = null;
        }
        this.oldValue = txt;
        this.newValue = newValue;
        this.offset = offset;
      }
      @Override public void undo() throws CannotUndoException {
        try {
          replaceIgnoringUndo(offset, newValue.length(), oldValue, null);
        } catch(BadLocationException ex) {
          throw new CannotUndoException();
        }
      }
      @Override public void redo() throws CannotRedoException {
        try {
          replaceIgnoringUndo(offset, oldValue.length(), newValue, null);
        } catch(BadLocationException ex) {
          throw new CannotUndoException();
        }
      }
      @Override public boolean canUndo() {
        return true;
      }
      @Override public boolean canRedo() {
        return true;
      }
    }
  };
  public JComponent makeUI() {
    tf.getDocument().addUndoableEditListener(um);
    doc.addUndoableEditListener(undoManager);
    field.setDocument(doc);
    field.setText("aaaaaaaaa");
    tf.setText("default");
    JPanel p = new JPanel();
    p.add(tf);
    p.add(field);
    p.add(new JButton(new AbstractAction("undo") {
      @Override public void actionPerformed(ActionEvent e) {
        try {
          undoManager.undo();
          um.undo();
        } catch(Exception ex) {
          java.awt.Toolkit.getDefaultToolkit().beep();
        }
      }
    }));
    p.add(new JButton(new AbstractAction("redo") {
      @Override public void actionPerformed(ActionEvent e) {
        try {
          undoManager.redo();
          um.redo();
        } catch(Exception ex) {
          java.awt.Toolkit.getDefaultToolkit().beep();
        }
      }
    }));
    p.add(new JButton(new AbstractAction("setText") {
      @Override public void actionPerformed(ActionEvent e) {
        String str = new Date().toString();
        tf.setText(str);
        field.setText(str);
      }
    }));
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
    f.getContentPane().add(new ReplaceUndoableEditDemo().makeUI());
    f.setSize(320, 240);
    f.setLocationRelativeTo(null);
    f.setVisible(true);
  }
}