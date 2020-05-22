public class TableWithBackground {

    public static void main(String[] args) {
        new TableWithBackground();
    }

    public TableWithBackground() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JDesktopPane desktopPane = new JDesktopPane();
                BackgroundInternalFrame backgroundInternalFrame = new BackgroundInternalFrame();
                desktopPane.add(backgroundInternalFrame);
                try {
                    backgroundInternalFrame.setMaximum(true);
                } catch (PropertyVetoException ex) {
                    ex.printStackTrace();
                }

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

    public class TransparentContentPane extends JPanel {

        public TransparentContentPane() {
            setOpaque(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setColor(getBackground());
            g2d.fillRect(0, 0, getWidth(), getHeight());
            g2d.setColor(Color.RED);
            g2d.drawLine(0, 0, getWidth(), getHeight());
            super.paintComponent(g2d); //To change body of generated methods, choose Tools | Templates.
            g2d.dispose();
        }
    }
}