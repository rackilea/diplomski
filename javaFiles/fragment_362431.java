public class TestScrollPane01 {

    public static void main(String[] args) {
        new TestScrollPane01();
    }

    public TestScrollPane01() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new MainPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class MainPane extends JPanel {

        private JScrollPane scrollPane;
        private int count;

        public MainPane() {
            setLayout(new BorderLayout());
            scrollPane = new JScrollPane(new JPanel());
            ((JPanel)scrollPane.getViewport().getView()).add(new JLabel("First"));
            add(scrollPane);

            JButton add = new JButton("Add");
            add.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JPanel view = ((JPanel)scrollPane.getViewport().getView());
                    view.add(new JLabel("Added " + (++count)));
                    view.validate();
                }
            });

            add(add, BorderLayout.SOUTH);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

    }

}