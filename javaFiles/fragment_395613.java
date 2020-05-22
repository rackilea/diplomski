public class TableBackground {

    private BufferedImage background;

    public static void main(String[] args) {
        new TableBackground();
    }

    public TableBackground() {
        try {
            background = ImageIO.read(new File("C:/Users/swhitehead/Documents/My Dropbox/issue362.jpg"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JDesktopPane desktopPane = new JDesktopPane();
                JInternalFrame ittyFrame = new JInternalFrame("Hello", true, true, true, true);
                ittyFrame.setSize(100, 100);
                ittyFrame.setLocation(0, 0);
                ittyFrame.setVisible(true);
                desktopPane.add(ittyFrame);
                try {
                    ittyFrame.setMaximum(true);
                } catch (PropertyVetoException ex) {
                    ex.printStackTrace();
                }

                Object[][] data = new Object[50][4];
                for (int row = 0; row < 50; row++) {
                    for (int col = 0; col < 4; col++) {
                        data[row][col] = col + "." + row;
                    }
                }

                JTable table = new BackgroundImageTable();
                table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                table.setModel(new javax.swing.table.DefaultTableModel(
                                data,
                                new String[]{
                                    "Title 1", "Title 2", "Title 3", "Title 4"
                                }));

                table.setForeground(Color.WHITE);
                JScrollPane scrollPane = new JScrollPane(table);
                ittyFrame.setLayout(new BorderLayout());
                ittyFrame.add(scrollPane);

                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(desktopPane);
                frame.setSize(200, 200);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class BackgroundInternalFrame extends JInternalFrame {

        public BackgroundInternalFrame() {
            super("Hello", true, true, true, true);

            setSize(100, 100);
            setLocation(10, 10);
            setVisible(true);

            setContentPane(new TransparentContentPane());

            JTable table = new JTable();
            table.setModel(new javax.swing.table.DefaultTableModel(
                            new Object[][]{
                                {null, null, null, null},
                                {null, null, null, null},
                                {null, null, null, null},
                                {null, null, null, null}
                            },
                            new String[]{
                                "Title 1", "Title 2", "Title 3", "Title 4"
                            }));

            JScrollPane scrollPane = new JScrollPane(table);
            setLayout(new BorderLayout());
            add(scrollPane);

            scrollPane.setOpaque(false);
            scrollPane.getViewport().setOpaque(false);
            table.setOpaque(false);
            table.setBackground(new Color(255, 255, 255, 0));
        }
    }
}