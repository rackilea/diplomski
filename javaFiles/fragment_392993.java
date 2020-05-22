public class BadList {

    public static void main(String[] args) {
        new BadList();
    }

    public BadList() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {

            List<String> files = new ArrayList<>(2000);
            for (int index = 0; index < 2000; index++) {
                files.add(Integer.toString(index));
            }

            ListPane listPanel = new ListPane();
            listPanel.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.weightx = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridwidth = GridBagConstraints.REMAINDER;

            for (String file : files) {
                listPanel.add(new JCheckBox(file), gbc);
            }

            JScrollPane sp = new JScrollPane(listPanel);

            JPanel mainPanel = new JPanel(new BorderLayout());
            JPanel buttonPane = new JPanel(new GridBagLayout());
            buttonPane.add(new JButton("Select All"), gbc);
            buttonPane.add(new JButton("Deselect All"), gbc);
            gbc.weighty = 1;
            buttonPane.add(new JPanel(), gbc);

            mainPanel.add(sp, BorderLayout.CENTER);
            mainPanel.add(buttonPane, BorderLayout.EAST);

            setLayout(new BorderLayout());

            add(mainPanel);
        }
    }

    public class ListPane extends JPanel implements Scrollable {

        @Override
        public Dimension getPreferredScrollableViewportSize() {
            return new Dimension(200, 200);
        }

        @Override
        public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation, int direction) {
            return 128;
        }

        @Override
        public int getScrollableBlockIncrement(Rectangle visibleRect, int orientation, int direction) {
            return 128;
        }

        @Override
        public boolean getScrollableTracksViewportWidth() {
            return false;
        }

        @Override
        public boolean getScrollableTracksViewportHeight() {
            return false;
        }

    }
}