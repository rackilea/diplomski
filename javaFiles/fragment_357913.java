public class Console extends JPanel implements KeyListener, CaretListener {

    private static final String PROMPT = ">>";

    private JScrollPane scrollPane;
    private JTextArea consoleTextPane;

    private int startIndex;

    public Console() {
        super();

        // Create a text area
        consoleTextPane = new JTextArea();
        consoleTextPane.setText(PROMPT);
        consoleTextPane.setBorder(null);
        // Wraps the text if it goes longer than a line, but NOT on word boundary
        // like a normal console
        consoleTextPane.setLineWrap(true);
        consoleTextPane.setWrapStyleWord(false);

        // Set the initial caret position
        startIndex = consoleTextPane.getText().length();
        consoleTextPane.setCaretPosition(startIndex);

        // Add the caret and key listeners
        consoleTextPane.addCaretListener(this);
        consoleTextPane.addKeyListener(this);

        // Scrollbar, always show the vertical one
        scrollPane = new JScrollPane(consoleTextPane);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBorder(null);

        JPanel panelCenter = new JPanel(new BorderLayout());
        panelCenter.setPreferredSize(new Dimension(400, 200));
        panelCenter.add(scrollPane, BorderLayout.CENTER);

        add(panelCenter, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Console");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(new Console());
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // All processing in keyPressed
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // All processing in keyPressed
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                // ENTER key was pressed
                // Get the "Command"
                String command = consoleTextPane.getText().substring(startIndex);

                if (!command.isEmpty()) {
                    // TODO: do something with the command
                    consoleTextPane.append(System.lineSeparator() 
                            + "Command Entered: " + command);
                }

                // Update the start index and append a new prompt
                consoleTextPane.append(System.lineSeparator() + PROMPT);
                startIndex = consoleTextPane.getText().length();

                // Consume the ENTER key event so further processing is not
                // performed
                e.consume();
                break;
            case KeyEvent.VK_BACK_SPACE:
                // Make sure this is a valid delete
                if (consoleTextPane.getCaretPosition() <= startIndex) {
                    e.consume();
                    Toolkit.getDefaultToolkit().beep();
                }

                break;
            // TODO: add key presses here as desired
            default:
                //System.out.println("Unhandled: " + e.getKeyCode());
                break;
        }
    }

    @Override
    public void caretUpdate(CaretEvent e) {
        // Ensure that the caret position can only be a valid location
        if (e.getDot() < startIndex) {
            consoleTextPane.setCaretPosition(startIndex);
            Toolkit.getDefaultToolkit().beep();
        }
    }
}