import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.util.Vector;

public class UnicodeNameList {

    private JComponent ui = null;

    UnicodeNameList() {
        initUI();
    }

    public final void initUI() {
        if (ui!=null) return;

        ui = new JPanel(new BorderLayout(4,4));
        ui.setBorder(new EmptyBorder(4,4,4,4));
        Vector<String> unicodeNames = new Vector<>();
        Vector<String> unicodeDir = new Vector<>();
        Vector<String> unicodeChar = new Vector<>();
        for (int ii=0; ii<1000; ii++) {
            unicodeChar.add(new String(Character.toChars(ii)));
            unicodeNames.add(Character.getName(ii));
            unicodeDir.add("" + Character.getDirectionality(ii));
        }
        ui.add(new JScrollPane(new JList(unicodeChar)), BorderLayout.LINE_START);
        JList list = new JList(unicodeNames);
        LongListCellRenderer llcr = new LongListCellRenderer();
        list.setCellRenderer(llcr);
        ui.add(new JScrollPane(list));
        ui.add(new JScrollPane(new JList(unicodeDir)), BorderLayout.LINE_END);
    }

    public JComponent getUI() {
        return ui;
    }

    public static void main(String[] args) {
        Runnable r = () -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception useDefault) {
            }
            UnicodeNameList o = new UnicodeNameList();

            JFrame f = new JFrame(o.getClass().getSimpleName());
            f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            f.setLocationByPlatform(true);

            f.setContentPane(o.getUI());
            f.pack();
            f.setMinimumSize(f.getSize());

            f.setVisible(true);
        };
        SwingUtilities.invokeLater(r);
    }
}

class LongListCellRenderer extends DefaultListCellRenderer {

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        String pre = "<html><body style='width: 100px;'>";
        JLabel l = (JLabel)super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        String s = value==null ? "Null" : value.toString();
        l.setText(pre + s);
        return l;
    }
}