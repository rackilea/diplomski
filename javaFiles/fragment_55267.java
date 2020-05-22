public class TestApplet04 extends JApplet implements ActionListener {

    private JTextField textField;
    private JTextArea textArea;
    private String newline;

    public void init() {
        textField = new JTextField(20);
        textField.setText("Enter your question here.");
        textField.selectAll();
        textField.addActionListener(this);

        textArea = new JTextArea(10, 20);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        // Add Components to the Applet.
        GridBagLayout gridBag = new GridBagLayout();
        Container contentPane = getContentPane();
        contentPane.setLayout(gridBag);
        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;

        c.fill = GridBagConstraints.HORIZONTAL;
        gridBag.setConstraints(textField, c);
        contentPane.add(textField);

        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        gridBag.setConstraints(scrollPane, c);

        contentPane.add(scrollPane);

        newline = System.getProperty("line.separator");
    }

    public void actionPerformed(ActionEvent event) {
        String text = textField.getText();
        String question = "";
        String answer = "";

        question = textField.getText();
//        question = ProcessString(question);
//        answer = Answer(question);
        textArea.append(text + newline);
        textArea.append(answer + newline);
        textField.selectAll();
    }
}