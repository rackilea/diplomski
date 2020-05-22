import java.util.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.datatransfer.*;
import javax.swing.*;
public class BasicDnD {
  private JList list;
  public JList makeList() {
    DefaultListModel<String> m = new DefaultListModel<>();
    m.addElement("Martha Washington");
    m.addElement("Abigail Adams");
    m.addElement("Martha Randolph");
    list = new JList<String>(m);
    list.setTransferHandler(new TransferHandler() {
      @Override public boolean canImport(TransferHandler.TransferSupport info) {
        if (!info.isDataFlavorSupported(DataFlavor.stringFlavor)) {
          return false;
        }
        JList.DropLocation dl = (JList.DropLocation)info.getDropLocation();
        if (dl.getIndex() == -1) {
          return false;
        }
        return true;
      }
      @Override public int getSourceActions(JComponent c) {
        setDragImage(makeImageFromString(c));
        return COPY;
      }
      private final JPanel p = new JPanel();
      private BufferedImage br;
      private int width, height;
      private BufferedImage makeImageFromString(JComponent src) {
        JList l = (JList)src;
        int idx = l.getSelectedIndex();
        Rectangle rect = list.getCellBounds(idx,idx);
        if(rect==null) return null;
        if(br==null || rect.width!=width || rect.height!=height) {
          width  = rect.width;
          height = rect.height;
          br = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
        }
        Component c = l.getCellRenderer().getListCellRendererComponent(
            l, l.getSelectedValue(), idx, false, false);
        Graphics g = br.getGraphics();
        g.clearRect(0,0,width,height);
        SwingUtilities.paintComponent(g, c, p, 0, 0, width, height);
        g.dispose();
        return br;
      }
      @Override protected Transferable createTransferable(JComponent c) {
        JList list = (JList)c;
        Object[] values = list.getSelectedValues();
        StringBuffer buff = new StringBuffer();
        for (int i = 0; i < values.length; i++) {
          Object val = values[i];
          buff.append(val == null ? "" : val.toString());
          if (i != values.length - 1) {
            buff.append("\n");
          }
        }
        return new StringSelection(buff.toString());
      }
    });
    list.setDropMode(DropMode.ON_OR_INSERT);
    list.setDragEnabled(true);
    return list;
  }
  public JComponent makeUI() {
    JPanel panel = new JPanel(new GridLayout(2,1));
    JTextArea textArea = new JTextArea("Drag here from JList!");
    panel.add(new JScrollPane(textArea));
    panel.add(new JScrollPane(makeList()));
    return panel;
  }
  private static void createAndShowGUI() {
    JFrame f = new JFrame("BasicDnD");
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setContentPane(new BasicDnD().makeUI());
    f.setSize(320, 320);
    f.setLocationRelativeTo(null);
    f.setVisible(true);
  }
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      @Override public void run() { createAndShowGUI(); }
    });
  }
}