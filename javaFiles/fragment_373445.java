public class TestPasswordField {

    public static void main(String[] args) {
        new TestPasswordField();
    }

    public TestPasswordField() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame();
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

        private JPasswordField password;
        private JProgressBar progressBar;

        public TestPane() {
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.fill = GridBagConstraints.HORIZONTAL;

            password = new JPasswordField(10);
            progressBar = new JProgressBar(0, 10);
            password.getDocument().addDocumentListener(new DocumentListener() {

                protected void updateProgress() {
                    progressBar.setValue(password.getPassword().length);
                }

                @Override
                public void insertUpdate(DocumentEvent e) {
                    updateProgress();
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    updateProgress();
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    updateProgress();
                }
            });

            add(password, gbc);
            gbc.gridy++;
            add(progressBar, gbc);
        }

    }

}