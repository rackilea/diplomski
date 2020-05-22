import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.border.LineBorder;
//based on @trashgod code from http://stackoverflow.com/a/7706684/714968
public class FocusingPanel extends JFrame {

    private static final long serialVersionUID = 1L;
    private int elements = 10;
    private List<GridPanel> list = new ArrayList<GridPanel>();
    private final JFrame mainFrame = new JFrame();
    private final JPanel fatherPanel = new JPanel();

    public FocusingPanel() {
        fatherPanel.setLayout(new GridLayout(elements, elements));
        for (int i = 0; i < elements * elements; i++) {
            int row = i / elements;
            int col = i % elements;
            GridPanel gb = new GridPanel(row, col);
            list.add(gb);
            fatherPanel.add(gb);
        }
        mainFrame.setLayout(new BorderLayout(5, 5));
        mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        mainFrame.add(fatherPanel, BorderLayout.CENTER);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    private GridPanel getGridPanel(int r, int c) {
        int index = r * elements + c;
        return list.get(index);
    }

    private class GridPanel extends JPanel {

        private int row;
        private int col;

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(20, 20);
        }

        public GridPanel(int row, int col) {
            this.row = row;
            this.col = col;
            this.setBackground(Color.red);
            this.setBorder(new LineBorder(Color.black,1));
            this.addMouseListener(new MouseListener() {

                @Override
                public void mouseClicked(MouseEvent e) {
                    int r = GridPanel.this.row;
                    int c = GridPanel.this.col;
                    GridPanel gb = FocusingPanel.this.getGridPanel(r, c);
                    System.out.println("r" + r + ",c" + c
                            + " " + (GridPanel.this == gb)
                            + " " + (GridPanel.this.equals(gb)));
                }

                @Override
                public void mousePressed(MouseEvent e) {
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    int r = GridPanel.this.row;
                    int c = GridPanel.this.col;
                    GridPanel gb = FocusingPanel.this.getGridPanel(r, c);
                    System.out.println("r" + r + ",c" + c
                            + " " + (GridPanel.this == gb)
                            + " " + (GridPanel.this.equals(gb)));
                    setBackground(Color.blue);

                }

                @Override
                public void mouseExited(MouseEvent e) {
                    setBackground(Color.red);
                }
            });
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                FocusingPanel focusingPanel = new FocusingPanel();
            }
        });
    }
}