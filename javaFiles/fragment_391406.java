import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Sample2 extends JFrame {
  public Sample2() {
    init();
  }

  private void init() {
    JTable table = new JTable(5, 5);
    DefaultCellEditor cellEditor = new DefaultCellEditor(new EditorCombo());
    cellEditor.setClickCountToStart(2);
    table.getColumnModel().getColumn(0).setCellEditor(cellEditor);
    table.setRowHeight(30);
    table.setCellSelectionEnabled(true);
    add(new JScrollPane(table));
  }

  public static void main(String[] args) {
    setUpUI("Nimbus");
    SwingUtilities.invokeLater(new Runnable() {

      @Override
      public void run() {
        Sample2 samp = new Sample2();
        samp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        samp.setTitle("Table Test");
        samp.pack();
        samp.setLocationRelativeTo(null);
        samp.setVisible(true);
      }
    });
  }

  private static void setUpUI(String ui) {
    try {
      for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
        if (ui.equals(info.getName())) {
          UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException | InstantiationException
             | IllegalAccessException | UnsupportedLookAndFeelException ex) {
      Logger.getLogger(Sample2.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}

class EditorCombo extends JComboBox<String> {
  public EditorCombo() {
    super();
    setEditable(true);
    for (int i = 0; i < 10; i++) {
      addItem("Sample" + i);
    }
  }
  @Override public void updateUI() {
    //super.updateUI();
    setUI(new javax.swing.plaf.synth.SynthComboBoxUI() {
      @Override
      protected JButton createArrowButton() {
        JButton button = new JButton() {
          @Override
          public int getWidth() {
            return 0;
          }
        };
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setVisible(false);
        return button;
      }
      @Override
      public void configureArrowButton() {
      }
    });
    UIDefaults d = new UIDefaults();
//     putClientProperty("Nimbus.Overrides", d);
//     putClientProperty("Nimbus.Overrides.InheritDefaults", false);
//     JComponent c = (JComponent) getEditor().getEditorComponent();
//     c.putClientProperty("Nimbus.Overrides", d);
//     c.putClientProperty("Nimbus.Overrides.InheritDefaults", false);
//     c.setBorder(BorderFactory.createLineBorder(Color.BLACK));

    Painter<JComponent> emptyPainter = new Painter<JComponent>() {
      @Override public void paint(Graphics2D g, JComponent c, int w, int h) {
        /* Empty painter */
      }
    };
    d.put("TextField.borderPainter", emptyPainter);
    d.put("TextField[Enabled].borderPainter", emptyPainter);
    d.put("TextField[Focused].borderPainter", emptyPainter);
    d.put("ComboBox:\"ComboBox.textField\"[Enabled].backgroundPainter", emptyPainter);
    d.put("ComboBox:\"ComboBox.textField\"[Selected].backgroundPainter", emptyPainter);
    d.put("ComboBox[Editable+Focused].backgroundPainter", emptyPainter);
    putClientProperty("Nimbus.Overrides", d);
    JComponent c = (JComponent) getEditor().getEditorComponent();
    c.putClientProperty("Nimbus.Overrides", d);
    c.setBorder(BorderFactory.createLineBorder(Color.BLACK));
  }
}