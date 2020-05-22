import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class LayeredCellRenderer {

    public static void main(String[] args) {
        new LayeredCellRenderer();
    }

    public LayeredCellRenderer() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    try {
                        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    }

                    BufferedImage pic = ImageIO.read(new File("Photo01.jpg"));

                    DefaultTableModel model = new DefaultTableModel(
                            new Object[][]{{pic, "Sophia", ""}},
                            new Object[]{"Picture", "Name", "Close"});

                    JTable table = new JTable(model);
                    table.setRowHeight(86);
                    table.getColumnModel().getColumn(0).setCellRenderer(new SecutiryBadgeTableCellRenderer());

                    JFrame frame = new JFrame("Testing");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setLayout(new BorderLayout());
                    frame.add(new JScrollPane(table));
                    frame.pack();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public static class SecutiryBadgeTableCellRenderer extends DefaultTableCellRenderer {

        protected static BufferedImage background;
        private JLabel subImage;

        public SecutiryBadgeTableCellRenderer() {
            try {
                background = ImageIO.read(new File("Background.jpg"));
                setIcon(new ImageIcon(background));
                setLayout(new GridBagLayout());
                subImage = new JLabel();
                subImage.setHorizontalAlignment(JLabel.LEFT);
                subImage.setVerticalAlignment(JLabel.TOP);
                subImage.setBorder(new EmptyBorder(30, 10, 0, 0));
                add(subImage);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            super.getTableCellRendererComponent(table, null, isSelected, hasFocus, row, column);
            if (value instanceof Image) {
                Image img = (Image) value;
                subImage.setIcon(new ImageIcon((Image) value));
                subImage.setSize(subImage.getPreferredSize());
            } else {
                subImage.setIcon(null);
            }
            return this;
        }
    }
}