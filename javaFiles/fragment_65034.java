public class PaintComponentMouseListener extends JPanel {
    private static final long serialVersionUID = -4235693652966961963L;
    private List<JLabel> tiles;

    private List<JLabel> createTiles() {
        if(tiles == null) {
            tiles = new ArrayList<>();
            int x = 10;
            int y = 0;

            // Number of tiles painted
            for(int i=1;i<=9;i++) {
                String btn = "" + i;
                JLabel tile = new JLabel(btn, JLabel.CENTER);
                tile.setSize(new Dimension(140, 140));
                tile.setFont(tile.getFont().deriveFont(45f));
                tile.setLocation(x, y);
                tile.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        System.out.println("Clicked on button: " + btn);
                    }
                });

                tiles.add(tile);
                x += 150;
            }
        }
        return tiles;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.removeAll();
        for (JLabel i : createTiles()) {
            g.setColor(Color.CYAN);
            g.fillRoundRect(i.getX(), i.getY(), i.getWidth(), i.getHeight(), 20, 20);
            this.add(i);
        }

        revalidate();
    }

    private void start() {
        JFrame frame = new JFrame("Hello");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLayout(new GridLayout(3, 3));
        frame.setContentPane(this);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->{
            new PaintComponentMouseListener().start();
        });
    }

}