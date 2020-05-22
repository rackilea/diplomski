import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

public class SystemFontDisplayer extends JFrame {

    private static final long serialVersionUID = 1L;
    private JComboBox fontsBox;

    public SystemFontDisplayer() {

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] fontFamilyNames = ge.getAvailableFontFamilyNames();
        fontsBox = new JComboBox(fontFamilyNames);
        fontsBox.setSelectedItem(0);
        fontsBox.setRenderer(new ComboRenderer(fontsBox));
        fontsBox.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    final String fontName = fontsBox.getSelectedItem().toString();
                    fontsBox.setFont(new Font(fontName, Font.PLAIN, 16));
                }
            }
        });
        fontsBox.setSelectedItem(0);
        fontsBox.getEditor().selectAll();
        add(fontsBox, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 60));
        setLocation(200, 105);
        pack();

        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                fontsBox.setPopupVisible(true);
                fontsBox.setPopupVisible(false);
            }
        });
        setVisible(true);
    }

    public static void main(String arg[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                SystemFontDisplayer systemFontDisplayer = new SystemFontDisplayer();
            }
        });
    }

    private class ComboRenderer extends BasicComboBoxRenderer {

        private static final long serialVersionUID = 1L;
        private JComboBox comboBox;
        final DefaultListCellRenderer defaultRenderer = new DefaultListCellRenderer();
        private int row;

        private ComboRenderer(JComboBox fontsBox) {
            comboBox = fontsBox;
        }

        private void manItemInCombo() {
            if (comboBox.getItemCount() > 0) {
                final Object comp = comboBox.getUI().getAccessibleChild(comboBox, 0);
                if ((comp instanceof JPopupMenu)) {
                    final JList list = new JList(comboBox.getModel());
                    final JPopupMenu popup = (JPopupMenu) comp;
                    final JScrollPane scrollPane = (JScrollPane) popup.getComponent(0);
                    final JViewport viewport = scrollPane.getViewport();
                    final Rectangle rect = popup.getVisibleRect();
                    final Point pt = viewport.getViewPosition();
                    row = list.locationToIndex(pt);
                }
            }
        }

        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (list.getModel().getSize() > 0) {
                manItemInCombo();
            }
            final JLabel renderer = (JLabel) defaultRenderer.getListCellRendererComponent(list, value, row, isSelected, cellHasFocus);
            final Object fntObj = value;
            final String fontFamilyName = (String) fntObj;
            setFont(new Font(fontFamilyName, Font.PLAIN, 16));
            return this;
        }
    }
}