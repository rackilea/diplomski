public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        GridPane gp = new GridPane(5, 5);

        frame.add(gp, BorderLayout.EAST);

        frame.setVisible(true);
        frame.setSize(250, 250);
    }
}

class GridPane extends JPanel {

    public GridPane(int row, int col) {

        setLayout(new GridLayout(row, col));
        setPreferredSize(new Dimension(125, 125));
        setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));

        for (int i = 1; i <= (row * col); i++) {
            JPanel pan = new JPanel();
            pan.setBackground(Color.RED);
            pan.setPreferredSize(new Dimension(3, 3));
            pan.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            add(pan);
        }
    }
}