package com.bitplan.test.common;

import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import junit.framework.TestCase;

/**
 * test the event dispatching thread handling
 * 
 * @author wf
 *
 */
public class TestEDT extends TestCase {

  public static class Lock {

    boolean value;

    public Lock(boolean value) {
      super();
      this.value = value;
    } 
    /**
     * @return the value
     */
    public boolean isTrue() {
      return value;
    }

    /**
     * @param value the value to set
     */
    public void set(boolean value) {
      this.value = value;
    }
  }
  private JTextField field;
  private Lock modified=new Lock(false);
  private Lock  created=new Lock(false);

  /**
   * test UI handling
   * 
   * @throws InterruptedException
   */
  public void testUI() throws InterruptedException {
    // see
    // http://docs.oracle.com/javase/tutorial/uiswing/concurrency/initial.html
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        createAndShowGUI();
      }
    });
    synchronized(created) {
      while(!created.isTrue())
        created.wait();
    }
    field.getDocument().addDocumentListener(new DocumentListener() {
      public void flagModification() {
        synchronized(modified) {
          modified.set(true);
          modified.notify();
        }      
      }
      public void insertUpdate(DocumentEvent e) {
        flagModification();
      }

      @Override
      public void removeUpdate(DocumentEvent e) {     
        flagModification();
      }

      @Override
      public void changedUpdate(DocumentEvent e) {
        flagModification();        
      }
    });
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        updateField("fieldcontent");
      }
    });
    synchronized(modified) {
      while(!modified.isTrue())
      // http://stackoverflow.com/questions/2536692/a-simple-scenario-using-wait-and-notify-in-java?noredirect=1&lq=1
        modified.wait();
    }
  }

  /**
   * update the field with the new content;
   * 
   * @param newContent
   */
  protected void updateField(String newContent) {
    field.setText(newContent);
  }

  /**
   * create and show the given gui
   */
  protected void createAndShowGUI() {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setTitle("Example GUI");
    JPanel panel = new JPanel();
    field = new JTextField(30);
    panel.add(field);
    frame.setContentPane(panel);
    frame.pack();
    frame.setVisible(true);
    synchronized(created) {
      created.set(true);
      created.notify();
    }
  }
}