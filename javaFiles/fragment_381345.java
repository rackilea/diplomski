import java.awt.BasicStroke;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.SwingUtilities;
import javax.swing.UnsupportedLookAndFeelException;

public class TestComboBox {

    private static enum LineType {

        PLAIN {
            @Override
            public Stroke getStroke() {
                return new BasicStroke(1.0f, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER, 1.0f, new float[] { 1.0f }, 1);
            }
        },
        DOTTED {
            @Override
            public Stroke getStroke() {
                return new BasicStroke(1.0f, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER, 1.0f, new float[] { 0.1f, 5.0f }, 1);
            }

        },
        DASHED {
            @Override
            public Stroke getStroke() {
                return new BasicStroke(1.0f, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER, 1.0f, new float[] { 3.0f, 3.0f }, 1);
            }

        };
        public abstract Stroke getStroke();
    }

    public class LineRenderer extends JPanel implements ListCellRenderer {
        private LineType value;

        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            if (value instanceof LineType) {
                setLineType((LineType) value);
            } else {
                setLineType(null);
            }
            return this;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            if (value != null) {
                g2d.setStroke(value.getStroke());
                g.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2);
            }

        }

        private void setLineType(LineType value) {
            this.value = value;
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(50, 20);
        }

    }

    protected void initUI() {
        final JFrame frame = new JFrame(TestComboBox.class.getSimpleName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new GridBagLayout());
        final JComboBox comboBox = new JComboBox(LineType.values());
        comboBox.setRenderer(new LineRenderer());
        comboBox.setSelectedItem(null);
        comboBox.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        JOptionPane.showMessageDialog(comboBox, "You have selected " + comboBox.getSelectedItem());
                    }
                });
            }
        });
        panel.add(comboBox);
        frame.add(panel);
        frame.setSize(300, 100);
        frame.setVisible(true);
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException,
            UnsupportedLookAndFeelException {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new TestComboBox().initUI();
            }
        });
    }
}