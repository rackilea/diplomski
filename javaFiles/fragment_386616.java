public class TestUndecoratedFrame {

    public static void main(String[] args) {
        new TestUndecoratedFrame();
    }

    public TestUndecoratedFrame() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                TitlePane titlePane = new TitlePane();

                JFrame frame = new JFrame("Testing");
                frame.setUndecorated(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                ((JComponent)frame.getContentPane()).setBorder(new LineBorder(Color.BLACK));
                frame.add(titlePane, BorderLayout.NORTH);
                frame.add(new JLabel("This is your content", JLabel.CENTER));
                frame.setSize(200, 200);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TitlePane extends JPanel {

        public TitlePane() {
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.weightx = 1;
            gbc.anchor = GridBagConstraints.EAST;
            add(new CloseControl(), gbc);
        }
    }

    public class CloseControl extends JButton {

        public CloseControl() {
            setBorderPainted(false);
            setContentAreaFilled(false);
            setFocusPainted(false);
            setOpaque(false);
            setBorder(new EmptyBorder(0, 0, 8, 12));
            try {
                setRolloverIcon(new ImageIcon(ImageIO.read(getClass().getResource("/Highlighted.png"))));
                setRolloverEnabled(true);
                setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/Normal.png"))));
            } catch (IOException ex) {
                Logger.getLogger(TestUndecoratedFrame.class.getName()).log(Level.SEVERE, null, ex);
            }

            addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SwingUtilities.getWindowAncestor(CloseControl.this).dispose();
                }
            });
        }
    }
}