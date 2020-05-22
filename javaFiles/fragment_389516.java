public class Console extends JDialog {
JTextArea textArea = null;
/**
 * Launch the application.
 */
public static void main(String[] args) {
    try {
        Console dialog = new Console();
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setVisible(true);
    } catch (Exception e) {
        e.printStackTrace();
    }
}

private void updateTextPane(final String text) {
    SwingUtilities.invokeLater(new Runnable() {

        public void run() {
            textArea.append(text);  

        }
    });
}

/**
 * Create the dialog.
 */
public Console() {

    //Creating a stream to move consle output to anything else
    OutputStream out = new OutputStream() {

        @Override
        public void write(final int b) throws IOException {
            updateTextPane(String.valueOf((char) b));
        }

        @Override
        public void write(byte[] b, int off, int len) throws IOException {
            updateTextPane(new String(b, off, len));
        }

        @Override
        public void write(byte[] b) throws IOException {
            write(b, 0, b.length);
        }
    };

    System.setOut(new PrintStream(out, true));
    System.setErr(new PrintStream(out, true));

    setBounds(100, 100, 450, 300);
    getContentPane().setLayout(null);

    JButton btnNewButton = new JButton("New button");
    btnNewButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            System.out.println("hello");
        }
    });
    btnNewButton.setBounds(91, 192, 91, 23);
    getContentPane().add(btnNewButton);

    textArea = new JTextArea();
    textArea.setBounds(30, 11, 241, 136);
    getContentPane().add(textArea);
}
}