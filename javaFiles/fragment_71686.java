public class FilterChooser {

    JFileChooser chooser = new JFileChooser();
    JTextField tf = (JTextField) ((JPanel) ((JPanel) chooser.getComponent(3)).getComponent(0)).getComponent(1);

    FilterChooser() {

        tf.getDocument().addDocumentListener(new DocumentListener() {

            public void insertUpdate(DocumentEvent e) {

                modifyFilter();
            }

            public void removeUpdate(DocumentEvent e) {

                modifyFilter();
            }

            public void changedUpdate(DocumentEvent e) {

                modifyFilter();
            }
        });

        JFrame f = new JFrame();
        chooser.showOpenDialog(f);

        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }

    void modifyFilter() {

        final String text = tf.getText();
        chooser.setFileFilter(new FileFilter() {

            @Override
            public String getDescription() {

                return null;
            }

            @Override
            public boolean accept(File f) {

                return (f.isDirectory() || f.getName().startsWith(text));
            }
        });
    }

    public static void main(String[] args) {

        new FilterChooser();
    }
}