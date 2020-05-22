import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FontMetrics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;

public class TestListLayered {

    public static class LayeredListCellRenderer extends DefaultListCellRenderer {

        private JButton edit = new JButton("e");

        @Override
        public Component getListCellRendererComponent(final JList list, final Object value, final int index,
                final boolean isSelected, final boolean cellHasFocus) {
            final JLayeredPane pane = new JLayeredPane();
            final JLabel label = (JLabel) super.getListCellRendererComponent(list, value.toString(), index, isSelected,
                    cellHasFocus);
            label.setHorizontalAlignment(SwingConstants.RIGHT);
            label.setBounds(0, 0, 100, 20);
            pane.add(label, JLayeredPane.DEFAULT_LAYER);

            final FontMetrics fontMetrics = edit.getFontMetrics(edit.getFont());
            final int height2 = (int) (1.5 * fontMetrics.getHeight());
            edit.setBounds(0, 0, (int) (1.5 * fontMetrics.stringWidth("e")), height2);
            pane.add(edit, JLayeredPane.PALETTE_LAYER);

            pane.setPreferredSize(new Dimension(-1, height2));
            pane.setBorder(new LineBorder(Color.blue));
            return pane;
        }

        protected void buttonClicked(Point p) {
            System.out.println(edit.contains(p));
        }
    }

    public static void main(final String[] args) {
        new TestListLayered();
    }

    public TestListLayered() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                final JFrame f = new JFrame();
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                final JList<String> l = new JList<String>(new String[]{"item 1", "item 2"});
                l.setCellRenderer(new LayeredListCellRenderer());
                f.add(new JScrollPane(l));

                l.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        int index = l.locationToIndex(e.getPoint());
                        if (index > -1) {

                            Rectangle bounds = l.getCellBounds(index, index);
                            LayeredListCellRenderer cellRenderer = (LayeredListCellRenderer) l.getCellRenderer();
                            Component renderComp = cellRenderer.getListCellRendererComponent(l, l.getModel().getElementAt(index), index, false, false);
                            renderComp.setBounds(bounds);

                            Point local = new Point(e.getPoint());
                            local.x -= bounds.x;
                            local.y -= bounds.y;

                            cellRenderer.buttonClicked(local);

                        }
                    }
                });

                f.pack();
                f.setVisible(true);
            }
        });
    }
}